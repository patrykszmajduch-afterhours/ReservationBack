--delete from Reservation;
delete from Event_Details;
insert into Event_Details(event_id,title,info,type_event,location,date_Of)
values (0,'tests title','test info','test_type','test location',TO_DATE('17/12/2015', 'DD/MM/YYYY'));
insert into Event_Details(event_id,title,info,type_event,location,date_Of)
values (1,'tests title','test info','test_type','test location',TO_DATE('17/12/2015', 'DD/MM/YYYY'));
insert into Event_Details(event_id,title,info,type_event,location,date_Of)
values (2,'tests title2','test info2','test_typ2e','test location2',TO_DATE('17/12/2017', 'DD/MM/YYYY'));