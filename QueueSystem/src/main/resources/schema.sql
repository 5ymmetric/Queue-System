DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS TA;
DROP TABLE IF EXISTS Pictures;

CREATE TABLE Pictures (
  imageId INT AUTO_INCREMENT  PRIMARY KEY,
  image varbinary(max)
);

CREATE TABLE Users (
  userId INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  photoId int default null
);

CREATE TABLE TA (
  teachId INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  photoId INT default NULL,
  weekday VARCHAR(250) default NULL,
  startTime TIME (0) default NULL,
  endTime time (0) default NULL
);