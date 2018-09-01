DROP TABLE IF EXISTS `user`;
CREATE  TABLE  user (uid int(8),name VARCHAR(20),password VARCHAR(20), primary key(uid));
INSERT  INTO  user  VALUES('1','jacob','050818');


DROP TABLE IF EXISTS `Administrator`;
CREATE TABLE `Administrator` (Aid int(8), FirstName VARCHAR(20),LastName VARCHAR(20),username VARCHAR(20),password VARCHAR(20), PRIMARY KEY(Aid)) ;
INSERT INTO  Administrator VALUES('1','Jacob','Linux','jacob','050818');

DROP TABLE IF EXISTS `Apartment`;
CREATE TABLE `Apartment` (Apid int(8), StartRentTime DATE,EndRentTime DATE, Availability BOOLEAN,Price int(8), Acreage int(8),Location VARCHAR(20), AvailableDate DATE, PRIMARY KEY(Apid)) ;
INSERT  INTO  Apartment  VALUES('1','2018-9-1','2018-9-3', true,'1000','60','Parkvile','2018-8-10');

DROP TABLE IF EXISTS `Order`;
CREATE TABLE `Order` (Opid int(8),InspStartTime DATE,InspEndTime DATE, Availability BOOLEAN,Price int(8), Acreage int(8),Location VARCHAR(20), AvailableDate DATE,PRIMARY KEY(Oid),FOREIGN KEY(Uid, Apid) references on User(Uid)) ;
INSERT  INTO  Order  VALUES('1','2018-9-1','2018-9-3', true,'1000','60','Parkvile','2018-8-10');








