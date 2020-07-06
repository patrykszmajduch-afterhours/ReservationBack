--delete from Reservation;
delete from Event_Details;
insert into Event_Details(event_Id,title,info,type_event,location,date_Of,img_Ext)
values (1,'Miedzy nami trupami','test info','Spektakl','test location',TO_DATE('17/12/2015', 'DD/MM/YYYY'),'jpg');
insert into Event_Details(event_Id,title,info,type_event,location,date_Of,img_Ext)
values (2,'Dobrze się kłamie','test info','Spektakl','test location',TO_DATE('17/12/2015', 'DD/MM/YYYY'),'jpg');
insert into Event_Details(event_Id,title,info,type_event,location,date_Of,img_Ext)
values (3,'Pinokio','test info2','Spektakl','test location2',TO_DATE('17/12/2017', 'DD/MM/YYYY'),'jpg');