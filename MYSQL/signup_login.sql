use universitydb;

create table signup_login(
userID MEDIUMINT NOT NULL AUTO_INCREMENT ,
PRIMARY KEY (userID),
Email char(100) ,
password char(30) ,
job      char(30)
); 
#insert into signup2 (userNAME ,password,job )
#values('basma','123','Student');

select *from universitydb.signup_login;