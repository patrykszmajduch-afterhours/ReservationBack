--delete from Reservation;

--if Event_Details is not null {
delete from Event_Details;
delete from USERS_CREDENTIALS;
insert into Event_Details(event_Id,title,info,type_event,location,date_Of,img_Ext)
values (1,'Miedzy nami trupami','test info','Spektakl','test location',TO_DATE('17/12/2015', 'DD/MM/YYYY'),'jpg');
insert into Event_Details(event_Id,title,info,type_event,location,date_Of,img_Ext)
values (2,'Dobrze się kłamie','test info','Spektakl','test location',TO_DATE('17/12/2015', 'DD/MM/YYYY'),'jpg');
insert into Event_Details(event_Id,title,info,type_event,location,date_Of,img_Ext)
values (3,'Pinokio','test info2','Spektakl','test location2',TO_DATE('17/12/2017', 'DD/MM/YYYY'),'jpg');

insert  into USERS_CREDENTIALS(id,username,password,role)
values (1,'user','$2y$12$Uuc2BgG92ISiJTsLKcF5r.rBiiasYeDKB/LokzE5f51aE9Wli5776','user');
insert  into USERS_CREDENTIALS(id,username,password,role)
values (2,'admin','$2y$12$v5OXdjqdD25HiUZnzkcYy.4DjSDvVNymFwPzCtRrp/CVMOVQEFwdS','admin');
insert  into USERS_CREDENTIALS(id,username,password,role)
values (3,'admin1','$2y$12$v5OXdjqdD25HiUZnzkcYy.4DjSDvVNymFwPzCtRrp/CVMOVQEFwdS','admin1');
