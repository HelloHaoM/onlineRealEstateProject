drop table if exists order_has_admin;
drop table if exists apartment_has_admin;
drop table if exists inspection_order;
drop table if exists apartment;
drop table if exists client;
drop table if exists administrator;
drop table if exists user;


drop table if exists user;
create table user (id int not null auto_increment,firstName varchar(255),lastName varchar(255),userName varchar(255),password varchar(255), oid int, permission varchar(255),  primary key(id));
insert into user(firstName,lastName,userName,password,oid,permission) values ('kkk','dd','u1','123',1,'ok');


drop table if exists administrator;
create table administrator (id int not null auto_increment,firstName varchar(255),lastName varchar(255),userName varchar(255),password varchar(255), oid int, permission varchar(255),  primary key(id),foreign key(id) references user(id));
insert into administrator(firstName,lastName,userName,password,oid,permission) values ('kkk','dd','u1','123',1,'ok');


drop table if exists client;
create table client (id int not null auto_increment,firstName varchar(255),lastName varchar(255),userName varchar(255),password varchar(255), oid int, permission varchar(255),  primary key(id),foreign key(id) references user(id));
insert into client(firstName,lastName,userName,password,oid,permission) values ('kkk','dd','u1','123',1,'ok');


drop table if exists apartment;
create table apartment (apid int not null auto_increment,StartRentTime varchar(255), EndRentTime varchar(255),Availability varchar(255),price int, acreage int, location varchar(255), apartmentName varchar(255),  primary key(apid));
insert into apartment (StartRentTime, EndRentTime,Availability,price, acreage, location, apartmentName) values ('08/09/2018','09/09/2018','yes',600,100,'Parkvile','EmpirestateBuilding');
insert into apartment (StartRentTime, EndRentTime,Availability,price, acreage, location, apartmentName) values ('11/10/2018','11/10/2019','yes',800,80,'SouthBank','CrownBuilding');
insert into apartment (StartRentTime, EndRentTime,Availability,price, acreage, location, apartmentName) values ('11/07/2019','11/10/2020','yes',340,60,'Camberwell','Big House');
insert into apartment (StartRentTime, EndRentTime,Availability,price, acreage, location, apartmentName) values ('15/03/2017','11/10/2019','yes',720,120,'Box Hill','Very Big House');

drop table if exists inspection_order;
create table inspection_order (oid int not null auto_increment,inspStartTime varchar(255), inspEndTime varchar(255),  primary key(oid,id,apid),id int, apid int, foreign key(id) references client(id), foreign key(apid) references apartment(apid));
insert into inspection_order(inspStartTime, inspEndTime,id, apid) values ('08/09/2018','09/09/2018', 1, 1);
insert into inspection_order(inspStartTime, inspEndTime,id, apid) values ('08/09/2018','09/09/2018', 1, 2);
insert into inspection_order(inspStartTime, inspEndTime,id, apid) values ('08/09/2018','09/09/2018', 1, 3);

drop table if exists apartment_has_admin;
create table apartment_has_admin (id int not null,apid int not null, primary key(id,apid), foreign key(id) references administrator(id), foreign key(apid) references apartment(apid));
insert into apartment_has_admin(id, apid) values (1, 1);

drop table if exists order_has_admin;
create table order_has_admin (oid int not null,id int not null, primary key(oid,id), foreign key(oid) references inspection_order(oid), foreign key(id) references administrator(id));
insert into order_has_admin(oid, id) values (1, 1);


