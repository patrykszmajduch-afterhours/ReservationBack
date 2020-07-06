package rest.angular.demo.Controllers;


import org.apache.commons.io.IOUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rest.angular.demo.Data.EventDetailsResponse;
import rest.angular.demo.Data.EventDetails;
import rest.angular.demo.services.DataService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {
    final private DataService dataService;
       
    @Autowired
    public Controller(DataService dataService) {
        this.dataService = dataService;
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
}