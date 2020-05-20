package rest.angular.demo.Controllers;



import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.MediaType;
import rest.angular.demo.Data.EventDetails;
import rest.angular.demo.RepositoryEventDetails;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DataService {
    final RepositoryEventDetails repositoryEventDetails;

    @Autowired
    public DataService(RepositoryEventDetails repositoryEventDetails) {
        this.repositoryEventDetails = repositoryEventDetails;
    }


    @GetMapping(value = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getImage(@PathVariable int id) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/static/image.jpg");
        return IOUtils.toByteArray(in);
    }
    @GetMapping(value="/list/eventdetails", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<EventDetails> getListOfEventDetails(){
        List<EventDetails> eventDetailsList= new ArrayList<>();

        return eventDetailsList;
    }
}
