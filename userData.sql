use kpagilla;

drop table if exists users;
drop table if exists teach;
drop table if exists pictures;


CREATE TABLE pictures (
imageId int not null primary key auto_increment,
name varchar(255),
image longblob not null
)engine=InnoDB,collate=latin1_general_cs;

CREATE TABLE users (
    userId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    photoId int not null,
    password VARCHAR(255) NOT NULL,
    foreign key (photoId) references pictures(imageID),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
)engine=InnoDB,collate=latin1_general_cs;


CREATE TABLE teach (
    teachId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    teachName VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    photoID int not null,
    startTime time (0) not null,
    endTime time (0) not null,
    image blob,
    foreign key (photoID) references pictures(imageId),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
)engine=InnoDB,collate=latin1_general_cs;






