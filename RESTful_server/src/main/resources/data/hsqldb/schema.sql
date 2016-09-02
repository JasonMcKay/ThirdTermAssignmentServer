DROP TABLE User IF EXISTS;
DROP TABLE Vehicle IF EXISTS;

CREATE TABLE User (
  username VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  PRIMARY KEY(username)
);

CREATE TABLE Vehicle (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL,
  engine VARCHAR(100) NOT NULL,
  doors VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);