package rest.angular.demo.services;

import org.springframework.stereotype.Service;
import rest.angular.demo.data.EventDetails;
import rest.angular.demo.data.EventDetailsDTO;
import rest.angular.demo.repo.EventDetailsRepository;
import rest.angular.demo.ImgReaderWriter;
import rest.angular.demo.customException.EventDetailsNotFound;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
    final private EventDetailsRepository eventDetailsRepository;

    public DataService(EventDetailsRepository eventDetailsRepository) {
        this.eventDetailsRepository = eventDetailsRepository;
    }

    public boolean saveEventDetailsResponse(EventDetailsDTO eventDetailsDTO) {//metoda serwisu do zapisu
        boolean succes = true;
        EventDetails eventDetails = EventDetails.createEvent(eventDetailsDTO);
        eventDetailsRepository.save(eventDetails);//zapisanie obkietu w bazie pozwala nam wygenerowac automatyczne id
        String imageArray[] = eventDetailsDTO.getImg().split(",");//oddzielenie danych o obrazie wszystko co po przecinku zawiera wyglad obrazu
        if (imageArray.length < 2)
            succes = false;
        else {
            //example id = 1 ext = jpeg| image name = 1.jpeg
            String imageName = createFileName(eventDetails);//utworzenie nazwy zdjecia do zapisu
            ImgReaderWriter.decoder(eventDetailsDTO.getImg(), imageName);//zapisanie zdjecia
        }
        return succes;
    }

    public boolean updateEventDetailsResponse(EventDetailsDTO eventDetailsDTO) {//aktuaizacja danych jedna róznica od metody powyżej to dodanie usuniecia zdjecia po czym zapisanie nowego
        boolean succes = true;
        EventDetails eventDetails = EventDetails.createEvent(eventDetailsDTO);
        EventDetails entity = eventDetailsRepository.findById(eventDetailsDTO.getId()).get();
        entity.populateData(eventDetails);
        eventDetailsRepository.save(entity);

        String imageArray[] = eventDetailsDTO.getImg().split(",");
        if (imageArray.length < 2)
            succes = false;
        else {
            //example id = 1 ext = jpeg| image name = 1.jpeg
            String imageName = createFileName(eventDetails);
            ImgReaderWriter.deleteImg(imageName);
            ImgReaderWriter.decoder(eventDetailsDTO.getImg(), imageName);
        }
        return succes;
    }

    public EventDetailsDTO returnEventDetailsResponse(long id) {//zwrocenie wydarzenia o okonkretnym id
        EventDetails eventDetails = eventDetailsRepository.findById(id).orElseThrow(() -> new EventDetailsNotFound(id));
        String imageName = createFileName(eventDetails);
        String imageFile = ImgReaderWriter.encoder(imageName);
        EventDetailsDTO eventDetailsDTO = new EventDetailsDTO(eventDetails);
        eventDetailsDTO.setImg("data:image/" + eventDetails.getImgExt() + ";base64," + imageFile);
        return eventDetailsDTO;
    }

    public List<EventDetailsDTO> getListOfEventDetailsResponse() {//zwrocenie listy wszystkich eventow
        List<EventDetails> eventDetailsList = new ArrayList<>();
        eventDetailsList = (List<EventDetails>) eventDetailsRepository.findAll();


        List<EventDetailsDTO> eventDetailsDTOList = new ArrayList<>();
        for (EventDetails e : eventDetailsList) {
            String imageName = createFileName(e);
            String imageFile = ImgReaderWriter.encoder(imageName);
            EventDetailsDTO eventDetailsDTO = new EventDetailsDTO(e);
            eventDetailsDTO.setImg("data:image/" + e.getImgExt() + ";base64," + imageFile);
            eventDetailsDTOList.add(eventDetailsDTO);
        }
        return eventDetailsDTOList;
    }

    public EventDetails deleteEventDetails(long id) {//usuniecie wydarzenia z bazy danych
        EventDetails eventDetails = eventDetailsRepository.findById(id).orElseThrow(() -> new EventDetailsNotFound(id));
        eventDetailsRepository.deleteById(id);
        ImgReaderWriter.deleteImg(createFileName(eventDetails));
        return eventDetails;
    }

    private String createFileName(EventDetails eventDetails) {//prosta metoda to tworzenia nazwy zdjec
        return eventDetails.getId() + "." + eventDetails.getImgExt();
    }


}
