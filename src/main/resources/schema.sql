CREATE TABLE if not exists Reservation (
    reservationId   identity ,
    eventDetails LONG NOT NULL,
    info VARCHAR(128) NOT NULL,
    PRIMARY KEY (reservationId)
);
CREATE TABLE if not exists Event_Details (
    eventId   LONG  NOT NULL AUTO_INCREMENT,
    title VARCHAR(128) NOT NULL,
    info VARCHAR(128) NOT NULL,

    PRIMARY KEY (eventId)
);
ALTER TABLE Reservation
 add  foreign key (eventDetails) references Event_Details(eventId);
