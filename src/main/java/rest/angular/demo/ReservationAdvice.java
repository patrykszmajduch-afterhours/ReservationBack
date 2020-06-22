/*
package rest.angular.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import rest.angular.demo.customException.EventDetailsNotFound;
import rest.angular.demo.customException.ReservationNotFound;

@ControllerAdvice
public class ReservationAdvice {
    @ResponseBody
    @ExceptionHandler(EventDetailsNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String eventNotFoundHandler(EventDetailsNotFound ex) {
        return ex.getMessage();
    }
    @ResponseBody
    @ExceptionHandler(ReservationNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String reservationNotFoundHandler(ReservationNotFound ex) {
        return ex.getMessage();
    }
}
*/
