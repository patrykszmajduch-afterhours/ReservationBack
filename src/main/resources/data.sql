delete from Reservation;
delete from Event_Details;

insert into Event_Details(eventid,title,info)
values (1,'tests title','test info');
insert into Reservation (reservationid,eventDetails,info)
values (1,1,'test info');