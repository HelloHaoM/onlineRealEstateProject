drop table if exists user;
create table user (uid int not null auto_increment,firstName varchar(255),lastName varchar(255),userName varchar(255),password varchar(255), oid int, permission varchar(255),  primary key(uid));
insert into user(firstName,lastName,userName,password,oid,permission) values ('kkk','dd','u1','123',1,'ok');


drop table if exists administrator;
create table administrator (aid int not null auto_increment,firstName varchar(255),lastName varchar(255),userName varchar(255),password varchar(255), oid int, permission varchar(255),  primary key(aid));
insert into administrator(firstName,lastName,userName,password,oid,permission) values ('kkk','dd','u1','123',1,'ok');


drop table if exists client;
create table client (cid int not null auto_increment,firstName varchar(255),lastName varchar(255),userName varchar(255),password varchar(255), oid int, permission varchar(255),  primary key(cid));
insert into client(firstName,lastName,userName,password,oid,permission) values ('steve','aoki','steve','123',1,'ok');


drop table if exists apartment;
create table apartment (apid int not null auto_increment,StartRentTime varchar(255), EndRentTime varchar(255),Availability varchar(255),price int, acreage int, location varchar(255), apartmentName varchar(255),  primary key(apid));
insert into apartment (StartRentTime, EndRentTime,Availability,price, acreage, location, apartmentName) values ('08/09/2018','09/09/2018','yes',100,100,'parkvile','empirestatebuilding');



drop table if exists order;
create table order (oid int not null auto_increment,inspStartTime varchar(255), inspEndTime varchar(255),  primary key(oid),uid int, apid int, foreign key(uid) references user(uid), foreign key(apid) references apartment(apid));
insert into order(inspStartTime, inspEndTime,uid, apid) values ('08/09/2018','09/09/2018', 1, 1)