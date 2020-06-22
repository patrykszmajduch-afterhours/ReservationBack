package rest.angular.demo.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private String imgUrl;
}
