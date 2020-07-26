package rest.angular.demo.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@AllArgsConstructor
@Data
public class EventDetailsDTO {//obiekt do odbioru i mapowania repsonsów/requestów
    private long id;
    private String title;
    private String info;
    private String type;
    private String location;
    private Date date;
    private String imgExt;
    private String img;


    public EventDetailsDTO(EventDetails eventDetails){
        this.id = eventDetails.getId();
        this.title = eventDetails.getTitle();
        this.info = eventDetails.getInfo();
        this.type = eventDetails.getType();
        this.location = eventDetails.getLocation();
        this.date = eventDetails.getDate();
        this.imgExt = eventDetails.getImgExt();
        this.img ="";
    }
}
