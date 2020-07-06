/*CREATE TABLE if not exists Reservation (
    reservation_Id  identity ,
    event_Details_Id LONG NOT NULL,
    info VARCHAR(128) NOT NULL,
    PRIMARY KEY (reservation_Id)
);*/
CREATE TABLE if not exists Event_Details (
    event_Id   LONG  NOT NULL AUTO_INCREMENT,
    title VARCHAR(128) NOT NULL,
    info VARCHAR(128),
    type_event VARCHAR(128) NOT NULL,
    location VARCHAR(128) NOT NULL,
    date_Of DATE NOT NULL,
    img_Ext VARCHAR(20) NOT NULL,
    PRIMARY KEY (event_Id)
);
/*
ALTER TABLE Reservation
 add  foreign key (event_Details_Id) references Event_Details(event_Id);
*/
