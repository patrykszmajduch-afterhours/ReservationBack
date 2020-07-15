package rest.angular.demo.customException;

public class EventDetailsNotFound extends RuntimeException {//prosta obsługa błedu
    public EventDetailsNotFound(Long id){
        super("Could not find event "+id);
    }
}
