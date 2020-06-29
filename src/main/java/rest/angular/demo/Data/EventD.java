package rest.angular.demo.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@AllArgsConstructor
@Getter
@Data
public class EventD {

    private long id;
    private String title;
    private String info;
    private String type;
    private String location;
    private Date date;
    private String imgName;
    private String img;

   /* public EventD(long id, String title, String info, String type, String location, Date date, String imgName, String img) {
        this.id = id;
        this.title = title;
        this.info = info;
        this.type = type;
        this.location = location;
        this.date = date;
        this.imgName = imgName;

        System.out.println("działam!"+img);
        this.img = img;
    }*/
}
