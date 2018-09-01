DROP TABLE IF EXISTS `user`;
CREATE  TABLE  user (name VARCHAR(20),password VARCHAR(20));
INSERT  INTO  user  VALUES('jacob','050818');


DROP TABLE IF EXISTS `Administrator`;
CREATE TABLE `Administrator` (Aid int(8), FirstName VARCHAR(20),LastName VARCHAR(20),username VARCHAR(20),password VARCHAR(20)) ;
INSERT INTO  Administrator VALUES('1','Jacob','Linux','jacob','050818');

DROP TABLE IF EXISTS `Apartment`;
CREATE TABLE `Apartment` (Apid int(8), StartRentTime DATE,EndRentTime DATE, Availability BOOLEAN,Price int(8), Acreage int(8),Location VARCHAR(20), AvailableDate DATE) ;
INSERT  INTO  Apartment  VALUES('1','2018','3/9/2018', 'true','1000','60','Parkvile','8/2018-10/2018');







