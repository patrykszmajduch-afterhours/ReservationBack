package rest.angular.demo.Controllers;


import org.apache.commons.io.IOUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import org.springframework.http.MediaType;
import rest.angular.demo.Data.EventDetailsResponse;
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
    public List<EventDetailsResponse> getListOfEventDetails() {
        return dataService.getListOfEventDetailsResponse();
    }

    @GetMapping(value = "/eventdetails/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EventDetailsResponse getEventDetails(@PathVariable long id) {
        return dataService.returnEventDetailsResponse(id);
    }

    @PostMapping(value = "/eventdetails")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EventDetailsResponse createEventDetails(@RequestBody EventDetailsResponse eventDetailsResponse) {
        dataService.saveEventDetailsResponse(eventDetailsResponse);
        return eventDetailsResponse;
    }

    @PutMapping(value = "/eventdetails")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EventDetailsResponse updateEventDetails(@RequestBody EventDetailsResponse eventDetailsResponse) {
          dataService.updateEventDetailsResponse(eventDetailsResponse);
        return eventDetailsResponse;
    }

    @DeleteMapping(value = "/eventdetails/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EventDetails deleteEventDetails(@PathVariable long id) {

            return dataService.deleteEventDetails(id);
    }
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping(value="image/")
//    @ResponseBody
//    public String getImg(){
//        //"data:image/jpeg;base64,"+
//        String ext="jpeg";
////        return "data:image/"+ext+"base64," +dataService.encoder("1.png");
//    }

    //test resp
/*
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="image/test")
    @ResponseBody
    public EventDetailsResponse getEv(){
            //"data:image/jpeg;base64,"+
       */
/* EventDetailsResponse temp =EventDetails.createEventCommunication(eventDetailsRepository.findById((long)1).orElseThrow(() -> new EventDetailsNotFound((long)1)));
        temp = dataService.createResponse(temp);
        return temp;*//*

    }
*/


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