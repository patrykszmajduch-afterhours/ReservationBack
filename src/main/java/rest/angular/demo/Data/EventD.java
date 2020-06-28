package rest.angular.demo.Data;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@AllArgsConstructor
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

}
