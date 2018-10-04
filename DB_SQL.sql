drop table if exists order_has_admin;
drop table if exists apartment_has_admin;
drop table if exists inspection_order;
drop table if exists apartment;
drop table if exists client;
drop table if exists administrator;
drop table if exists users;

drop sequence if exists sql_au_inc_users ;
create sequence sql_au_inc_users increment by 1 minvalue 1 no maxvalue start with 1;

drop table if exists lock;
create table lock (lockableid int not null, owner varchar(255) not null, primary key (lockableid, owner));
insert into lock(lockableid, owner) values (1,'steve');

drop table if exists lock2;
drop table if exists lockap;
create table lockAp (apid int not null, inspectstarttime varchar(255) not null, owner varchar(255) not null);
insert into lockAp(apid, inspectstarttime, owner) values (1,'911','steve');

drop table if exists users;
create table users (id int not null UNIQUE default nextval('sql_au_inc_users'),firstName varchar(255),lastName varchar(255),userName varchar(255),password varchar(255), oid int, permission varchar(255),  primary key(id));
insert into users(firstName,lastName,userName,password,oid,permission) values ('kkk','dd','u1','123',1,'client');
insert into users(firstName,lastName,userName,password,oid,permission) values ('a1','a1','a1','123',1,'administrator');
insert into users(firstName,lastName,userName,password,oid,permission) values ('Tim','B','u2','123',1,'client');

drop sequence if exists sql_au_inc_adm;
create sequence sql_au_inc_adm increment by 1 minvalue 1 no maxvalue start with 1;

drop table if exists administrator;
create table administrator (id int not null UNIQUE default nextval('sql_au_inc_adm'),firstName varchar(255),lastName varchar(255),userName varchar(255),password varchar(255), oid int, permission varchar(255),  primary key(id),foreign key(id) references users(id));
insert into administrator(firstName,lastName,userName,password,oid,permission) values ('a1','a1','a1','123',1,'administrator');

drop sequence if exists sql_au_inc_cli;
create sequence sql_au_inc_cli increment by 1 minvalue 1 no maxvalue start with 1;

drop table if exists client;
create table client (id int not null UNIQUE default nextval('sql_au_inc_cli'),firstName varchar(255),lastName varchar(255),userName varchar(255),password varchar(255), oid int, permission varchar(255),  primary key(id),foreign key(id) references users(id));
insert into client(firstName,lastName,userName,password,oid,permission) values ('kkk','dd','u1','123',1,'client');
insert into client(firstName,lastName,userName,password,oid,permission) values ('Tim','B','u2','123',1,'client');

drop sequence if exists sql_au_inc_apa;
create sequence sql_au_inc_apa increment by 1 minvalue 1 no maxvalue start with 1;

drop table if exists apartment;
create table apartment (apid int not null UNIQUE default nextval('sql_au_inc_apa'),StartRentTime varchar(255), EndRentTime varchar(255),Availability varchar(255),price int, acreage int, location varchar(255), apartmentName varchar(255),  primary key(apid));
insert into apartment (StartRentTime, EndRentTime,Availability,price, acreage, location, apartmentName) values ('08/09/2018','09/09/2018','yes',600,100,'Parkvile','EmpirestateBuilding');
insert into apartment (StartRentTime, EndRentTime,Availability,price, acreage, location, apartmentName) values ('11/10/2018','11/10/2019','yes',800,80,'SouthBank','CrownBuilding');
insert into apartment (StartRentTime, EndRentTime,Availability,price, acreage, location, apartmentName) values ('11/07/2019','11/10/2020','yes',340,60,'Camberwell','Big House');
insert into apartment (StartRentTime, EndRentTime,Availability,price, acreage, location, apartmentName) values ('15/03/2017','11/10/2019','yes',720,120,'Box Hill','Very Big House');

drop sequence if exists sql_au_inc_ord;
create sequence sql_au_inc_ord increment by 1 minvalue 1 no maxvalue start with 1;

drop table if exists inspection_order;
create table inspection_order (oid int not null UNIQUE default nextval('sql_au_inc_ord'),inspStartTime varchar(255), inspEndTime varchar(255),  primary key(oid,id,apid),id int, apid int, foreign key(id) references client(id), foreign key(apid) references apartment(apid));
insert into inspection_order(inspStartTime, inspEndTime,id, apid) values ('08/09/2018','09/09/2018', 1, 1);
insert into inspection_order(inspStartTime, inspEndTime,id, apid) values ('08/09/2018','09/09/2018', 1, 2);
insert into inspection_order(inspStartTime, inspEndTime,id, apid) values ('08/09/2018','09/09/2018', 1, 3);

drop table if exists apartment_has_admin;
create table apartment_has_admin (id int not null,apid int not null, primary key(id,apid), foreign key(id) references administrator(id), foreign key(apid) references apartment(apid));


drop table if exists order_has_admin;
create table order_has_admin (oid int not null,id int not null, primary key(oid,id), foreign key(oid) references inspection_order(oid), foreign key(id) references administrator(id));



