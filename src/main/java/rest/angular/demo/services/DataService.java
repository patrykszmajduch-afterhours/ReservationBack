package rest.angular.demo.services;

import org.springframework.stereotype.Service;
import rest.angular.demo.Data.EventDetails;
import rest.angular.demo.Data.EventDetailsResponse;
import rest.angular.demo.EventDetailsRepository;
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


    public boolean saveEventDetailsResponse(EventDetailsResponse eventDetailsResponse){
        boolean succes=true;
        EventDetails eventDetails = EventDetails.createEvent(eventDetailsResponse);
        eventDetailsRepository.save(eventDetails);
        String imageArray[] = eventDetailsResponse.getImg().split(",");
        if(imageArray.length<2)
            succes=false;
        else{
            //example id = 1 ext = jpeg| image name = 1.jpeg
            String imageName= createFileName(eventDetails);
            ImgReaderWriter.decoder(eventDetailsResponse.getImg(),imageName);
        }
        return succes;
    }
    public boolean updateEventDetailsResponse(EventDetailsResponse eventDetailsResponse){
        boolean succes=true;
        EventDetails eventDetails = EventDetails.createEvent(eventDetailsResponse);
        EventDetails entity = eventDetailsRepository.findById(eventDetailsResponse.getId()).get();
        entity.populateData(eventDetails);
        eventDetailsRepository.save(entity);

        String imageArray[] = eventDetailsResponse.getImg().split(",");
        if(imageArray.length<2)
            succes=false;
        else{
            //example id = 1 ext = jpeg| image name = 1.jpeg
            String imageName= createFileName(eventDetails);
            ImgReaderWriter.deleteImg(imageName);
            ImgReaderWriter.decoder(eventDetailsResponse.getImg(),imageName);
        }
        return succes;
    }
    public EventDetailsResponse returnEventDetailsResponse(long id){
        EventDetails eventDetails = eventDetailsRepository.findById(id).orElseThrow(() -> new EventDetailsNotFound(id));
        String imageName= createFileName(eventDetails);
        String imageFile = ImgReaderWriter.encoder(imageName);
        EventDetailsResponse eventDetailsResponse = new EventDetailsResponse(eventDetails);
        eventDetailsResponse.setImg("data:image/"+eventDetails.getImgExt()+";base64,"+imageFile);
        return eventDetailsResponse;
    }

    public List<EventDetailsResponse> getListOfEventDetailsResponse(){
        List<EventDetails> eventDetailsList = new ArrayList<>();
        eventDetailsList = (List<EventDetails>) eventDetailsRepository.findAll();


        List<EventDetailsResponse> eventDetailsResponseList = new ArrayList<>();
        for(EventDetails e : eventDetailsList){
            String imageName= createFileName(e);
            String imageFile = ImgReaderWriter.encoder(imageName);
            EventDetailsResponse eventDetailsResponse = new EventDetailsResponse(e);
            eventDetailsResponse.setImg("data:image/"+e.getImgExt()+";base64,"+imageFile);
            eventDetailsResponseList.add(eventDetailsResponse);
        }
        return eventDetailsResponseList;
    }
    public EventDetails deleteEventDetails(long id){
        EventDetails eventDetails = eventDetailsRepository.findById(id).orElseThrow(() -> new EventDetailsNotFound(id));
        eventDetailsRepository.deleteById(id);
        ImgReaderWriter.deleteImg(createFileName(eventDetails));
        return eventDetails;
    }



    private String createFileName(EventDetails eventDetails){
        return eventDetails.getId()+"."+eventDetails.getImgExt();
    }




}
