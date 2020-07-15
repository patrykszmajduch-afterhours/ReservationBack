package rest.angular.demo.customException;

public class ReservationNotFound extends RuntimeException{//prosta obsługa błedu
    public ReservationNotFound(Long id){
        super("Could not find reservation " + id);
    }
}
