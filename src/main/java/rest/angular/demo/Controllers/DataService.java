package rest.angular.demo.Controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
public class DataService {

    @GetMapping("/")
    Response getJsonListOfReservation(){
        String message = "This is a plain text response";

        return Response
               .ok(message)
                .build();
    }
    @GetMapping("/data")
    Response getData(){
        
    }

}
