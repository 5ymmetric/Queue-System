DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS pictures;

CREATE TABLE pictures (
  imageId INT AUTO_INCREMENT  PRIMARY KEY,
  image longblob NOT NULL
);

CREATE TABLE users (
  userId INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  photoId int default null
);

CREATE TABLE teach (
  teachId INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  photoId INT default NULL,
  weekday VARCHAR(250) default NULL,
  startTime TIME (0) default NULL,
  endTime time (0) default NULL
);