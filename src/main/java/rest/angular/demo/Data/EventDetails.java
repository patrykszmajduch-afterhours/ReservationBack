package rest.angular.demo.Data;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class EventDetails {
    @Id
    public long eventDetailsId;
    public String title;
    public String info;
}
