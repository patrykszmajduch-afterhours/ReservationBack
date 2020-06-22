package rest.angular.demo.customException;

public class ReservationNotFound extends RuntimeException{
    public ReservationNotFound(Long id){
        super("Could not find reservation " + id);
    }
}
