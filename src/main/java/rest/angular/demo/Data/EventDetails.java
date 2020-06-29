package rest.angular.demo.Data;

import lombok.*;


import javax.persistence.*;
import java.awt.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Setter(AccessLevel.PROTECTED)
@Setter
public class EventDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_id")
    private long id;
    private String title;
    private String info;
    @Column(name ="type_event")
    private String type;
    private String location;
    @Column(name="date_of")
    private Date date;
    private String imgExtension;



    public static EventDetails createEvent(EventD eventD){
        EventDetails build = new EventDetails();
        build.setTitle(eventD.getTitle());
        build.setDate(eventD.getDate());
        build.setInfo(eventD.getInfo());
        build.setType(eventD.getType());
        build.setLocation(eventD.getLocation());
        build.setImgExtension(getExt(eventD.getImgName()));
        if(eventD.getId()!=0)
            build.setId(eventD.getId());
        return build;
    }
   private static String getExt(String text){
        String arr[]=text.split("\\.");
        if(arr.length<2)
            return "";
        return arr[1];
   }
}
