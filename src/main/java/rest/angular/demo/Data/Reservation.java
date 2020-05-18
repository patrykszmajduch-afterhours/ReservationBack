package rest.angular.demo.Data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Reservation {
    @Id
    public long reservationId;
    @ManyToOne
    private EventDetails eventDetails;
    public String info;

}
