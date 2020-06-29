package rest.angular.demo.Controllers;


import org.apache.commons.io.IOUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import org.springframework.http.MediaType;
import rest.angular.demo.Data.EventD;
import rest.angular.demo.Data.EventDetails;
//import rest.angular.demo.Data.Reservation;
//import rest.angular.demo.ReservationRepository;
import rest.angular.demo.EventDetailsRepository;
import rest.angular.demo.customException.EventDetailsNotFound;
import rest.angular.demo.services.DataService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {
    final EventDetailsRepository eventDetailsRepository;
    static String FILEPATH = "";
    static File file = new File(FILEPATH);
    final private DataService dataService;

    //    final ReservationRepository reservationRepository;
    @Autowired
    public Controller(EventDetailsRepository eventDetailsRepository, DataService dataService) {
        this.eventDetailsRepository = eventDetailsRepository;
//        this.reservationRepository = reservationRepository;
        this.dataService = dataService;
    }

    private void createData() {
        List<EventDetails> listEvent = new ArrayList<>();
//        for(int i =0;i<4;i++){
//            eventDetailsRepository.save(new EventDetails("title"+i,"info++"+i));
//        }
    }

    @GetMapping(value = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getImage(@PathVariable int id) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/static/image.jpg");
        return IOUtils.toByteArray(in);
    }

    @GetMapping(value = "/eventdetails")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<EventDetails> getListOfEventDetails() {
        createData();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<EventDetails> eventDetailsList = new ArrayList<>();
        eventDetailsList = (List<EventDetails>) eventDetailsRepository.findAll();
        return eventDetailsList;
    }

    @GetMapping(value = "/eventdetails/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EventDetails getEventDetails(@PathVariable long id) {
        return eventDetailsRepository.findById(id).orElseThrow(() -> new EventDetailsNotFound(id));
    }

    @PostMapping(value = "/eventdetails")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EventD createEventDetails(@RequestBody EventD eventDetails) {
//        eventDetails = eventDetailsRepository.save(eventDetails);
        System.out.println(eventDetails);
        EventDetails temp =  EventDetails.createEvent(eventDetails);
        eventDetailsRepository.save(temp);
        String arr[] = eventDetails.getImg().split(",");
        dataService.decoder(arr[1],temp.getId()+"."+temp.getImgExtension());
        temp.setImgExtension(dataService.encoder(temp.getId()+"."+temp.getImgExtension()));
        return eventDetails;
    }

    @PutMapping(value = "/eventdetails/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EventDetails updateEventDetails(@RequestBody EventDetails eventDetails, @PathVariable long id) {
        eventDetails = eventDetailsRepository.save(eventDetails);
        return eventDetails;
    }

    @DeleteMapping(value = "/eventdetails/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EventDetails deleteEventDetails(@PathVariable long id) {
        EventDetails temp = eventDetailsRepository.findById(id).orElseThrow(() -> new EventDetailsNotFound(id));
        eventDetailsRepository.deleteById(id);
        return temp;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="image/")
    @ResponseBody
    public String getImg(){
        //"data:image/jpeg;base64,"+
        String ext="jpeg";
        return "data:image/"+ext+"base64," +dataService.encoder("1.png");
    }



    /*@GetMapping(value="/download")
    @ResponseStatus(HttpStatus.OK)
    public byte[]
*/
}

//    @PostMapping(value="/reservation")
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    public Reservation createEventDetails(@RequestBody Reservation reservation){
//       reservation=reservationRepository.save(reservation);
//       return reservation;
//    }
//  /*  @PutMapping(value="/reservation/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public Reservation updateReservation(@RequestBody Reservation reservation,@PathVariable long id) {
//        reservation.setId(id);
//        reservation = reservationRepository.save(reservation);
//        return reservation;
//    }
//
//
//    @GetMapping(value="/reservations")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.FOUND)
//    public List<Reservation> getListOfReservation(){
//        return (List<Reservation>) reservationRepository.findAll();
//    }
//
//    @GetMapping(value="/reservation/{id}")
//    @ResponseStatus(HttpStatus.FOUND)
//    @ResponseBody
//    public Reservation getReservation(@PathVariable long id){
//        return reservationRepository.findById(id).orElseThrow(()->new ReservationNotFound(id));
//    }
//    @DeleteMapping(value="/reservation/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public String deleteReservation(@PathVariable long id){
//        if(reservationRepository.existsById(id)) {
//            reservationRepository.deleteById(id);
//            return "Done";
//        }
//        return "Already done";
//    }
//
//}
//*/