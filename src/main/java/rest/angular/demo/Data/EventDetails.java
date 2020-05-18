package rest.angular.demo.Data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@Data
public class EventDetails {
    @Id
    public long eventDetailsId;
    public String title;
    public String info;
}
