CREATE DATABASE primejavaJWC CHARACTER SET utf8 COLLATE utf8_general_ci;

use primejavaJWC;

CREATE TABLE memberinfo(
  pid INT NOT NULL AUTO_INCREMENT ,
  id VARCHAR(20) NOT NULL UNIQUE ,
  pw VARCHAR(20) NOT NULL ,
  name VARCHAR(10)  ,
  age INT(2)  ,
  gender ENUM('남자','여자')  ,
  region ENUM('서울','경기도','강원도','충청도','경상도','전라도','제주도')  ,
  phone INT(20)  ,
  intro TEXT(300)  ,
  bloodT ENUM('A','B','O','AB')  ,
  myType VARCHAR(15)  ,
  myTypeB ENUM('A','B','O','AB') ,
  profilecheck INT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (pid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO memberinfo (id, pw, name, age, gender, region, phone, intro, bloodT, myType, myTypeB)
    VALUES ('test5','test','test',25,'남자','서울',01088387684,'안녕반가워요사랑해요','B','귀여움','B');

CREATE TABLE memoservice(
  pid INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(30) NOT NULL ,
  sendid VARCHAR(20) NOT NULL ,
  getid VARCHAR(20) NOT NULL ,
  text TEXT(300) NOT NULL ,
  completed INT(1) NOT NULL ,
  PRIMARY KEY (pid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE primejavaJWC.memberinfo;

INSERT INTO memberinfo (id,pw) VALUES ('tdest','teststs');

UPDATE memberinfo SET name = '' , age = '12' , gender = '남자' , region = '서울' , phone = '123' , intro = '' , bloodT = 'B' , myType = '' , myTypeB = 'B' WHERE id = 'test1';

SELECT * FROM memberinfo WHERE id = "test";