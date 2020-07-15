package rest.angular.demo.data;

import lombok.*;


import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PROTECTED)

public class EventDetails {//model danych zapisywany do bazy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private long id;
    private String title;
    private String info;
    @Column(name = "type_event")
    private String type;
    private String location;
    @Column(name = "date_of")
    private Date date;
    private String imgExt;


    public static EventDetails createEvent(EventDetailsDTO eventDetailsDTO) {
        EventDetails build = new EventDetails();
        build.setTitle(eventDetailsDTO.getTitle());
        build.setDate(eventDetailsDTO.getDate());
        build.setInfo(eventDetailsDTO.getInfo());
        build.setType(eventDetailsDTO.getType());
        build.setLocation(eventDetailsDTO.getLocation());
        build.setImgExt(eventDetailsDTO.getImgExt());
        build.setId(eventDetailsDTO.getId());
        return build;
    }
    public void populateData(EventDetails eventDetails){
        this.id=eventDetails.getId();
        this.title=eventDetails.getTitle();
        this.info=eventDetails.getInfo();
        this.type=eventDetails.getType();
        this.location=eventDetails.getLocation();
        this.date=eventDetails.getDate();
        this.imgExt=eventDetails.getImgExt();
    }


    private static String getExt(String text) {
        String arr[] = text.split("\\.");
        if (arr.length < 2)
            return "";
        return arr[1];
    }
}
