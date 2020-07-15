package rest.angular.demo.repo;

import org.springframework.data.repository.CrudRepository;
import rest.angular.demo.data.EventDetails;

public interface EventDetailsRepository extends CrudRepository<EventDetails,Long> {//prosta rozszerzenie klasy do obslugi bazy danych
}

