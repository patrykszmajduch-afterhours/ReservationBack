delete from Event_Details;
delete from Reservation;
insert into Event_Details(title,info)
values ('tests title','test info');
insert into Reservation (eventDetails,info)
values (1,'test info');