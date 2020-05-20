package rest.angular.demo;

import org.springframework.data.repository.CrudRepository;
import rest.angular.demo.Data.EventDetails;

public interface RepositoryEventDetails extends CrudRepository<EventDetails,Long> {
}
