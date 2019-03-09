
DROP TABLE IF EXISTS t_customer ;

CREATE TABLE t_customer (
	id  INT(5) PRIMARY KEY ,
	email  VARCHAR(60)  UNIQUE NOT NULL,
	password VARCHAR(32) NOT NULL ,
	nickname VARCHAR(150) ,
	gender VARCHAR(3) ,
	birthdate DATE ,
	married	 CHAR(1)
);

