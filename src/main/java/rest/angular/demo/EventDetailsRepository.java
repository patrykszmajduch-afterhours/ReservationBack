package rest.angular.demo;

import org.springframework.data.repository.CrudRepository;
import rest.angular.demo.Data.EventDetails;

public interface EventDetailsRepository extends CrudRepository<EventDetails,Long> {
}

