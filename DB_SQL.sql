DROP TABLE IF EXISTS `Client`;
CREATE  TABLE  Client (Cid int(8),FirstName VARCHAR(20), LastName VARCHAR (20),UserName VARCHAR(20), Password VARCHAR(20), primary key(Cid));
INSERT  INTO  Client  VALUES('1','jacob','050818');


DROP TABLE IF EXISTS `Administrator`;
CREATE TABLE `Administrator` (Aid int(8), FirstName VARCHAR(20),LastName VARCHAR(20),UserName VARCHAR(20),Password VARCHAR(20), PRIMARY KEY(Aid)) ;
INSERT INTO  Administrator VALUES('1','Jacob','Linux','jacob','050818');

DROP TABLE IF EXISTS `Apartment`;
CREATE TABLE `Apartment` (Apid int(8), StartRentTime DATE,EndRentTime DATE, Availability BOOLEAN,Price int(8), Acreage int(8),Location VARCHAR(20), AvailableDate DATE, PRIMARY KEY(Apid)) ;
INSERT INTO Apartment  VALUES('1','2018-9-1','2018-9-3', true,'1000','60','Parkvile','2018-8-10');

DROP TABLE IF EXISTS `Order`;
CREATE TABLE `Order` (Oid int(8),InspStartTime DATE,InspEndTime DATE,PRIMARY KEY(Oid)) ;
INSERT INTO Order VALUES('1','2018-9-1','2018-9-3', '1','1');

DROP TABLE IF EXISTS `Order1`;
CREATE TABLE `Order1` (Oid int(8),InspStartTime DATE,InspEndTime DATE,PRIMARY KEY(Oid), Cid int(8), Apid int(8),foreign key(Cid) references Client(Cid) ON DELETE SET NULL ON UPDATE CASCAD, constraint foreign key(Apid) references Apartment(Apid) ON DELETE SET NULL ON UPDATE CASCADE ) ;
INSERT INTO Order1 VALUES('1','2018-9-1','2018-9-3','1','1');






