package rest.angular.demo.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rest.angular.demo.Data.EventDetailsDTO;
import rest.angular.demo.Data.EventDetails;
import rest.angular.demo.services.DataService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")//zezwala na zapytania z podanego adresu
@RestController//adnotacja służąca do implementacji restowego serwisu
public class Controller {
    final private DataService dataService;

    @Autowired
    public Controller(DataService dataService) {
        this.dataService = dataService;
    }//wstrzykniecie zależności  serwisu do obśługi danych

    @GetMapping(value = "/eventdetails")//zmapowanie zapytania pod dany adres
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<EventDetailsDTO> getListOfEventDetails() {//metoda do obsługi zapytania odnośnie listy wydarzeń
        return dataService.getListOfEventDetailsResponse();
    }

    @GetMapping(value = "/eventdetails/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EventDetailsDTO getEventDetails(@PathVariable long id) {//metoda do obsługi zapytania odnośnie konkretnego wydarzenia
        return dataService.returnEventDetailsResponse(id);
    }

    @PostMapping(value = "/eventdetails")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EventDetailsDTO createEventDetails(@RequestBody EventDetailsDTO eventDetailsDTO) {//metoda obsługująca dodanie wydarzenia
        dataService.saveEventDetailsResponse(eventDetailsDTO);
        return eventDetailsDTO;
    }

    @PutMapping(value = "/eventdetails")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EventDetailsDTO updateEventDetails(@RequestBody EventDetailsDTO eventDetailsDTO) {//dodanie zmian do wydarzenia
        dataService.updateEventDetailsResponse(eventDetailsDTO);
        return eventDetailsDTO;
    }

    @DeleteMapping(value = "/eventdetails/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EventDetails deleteEventDetails(@PathVariable long id) {//metoda do obsługi wykasowania wydarzenia
        return dataService.deleteEventDetails(id);
    }
}