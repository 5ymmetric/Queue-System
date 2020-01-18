use kpagilla;

drop table if exists users;
drop table if exists teach;

CREATE TABLE users (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE teach (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    teachName VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    startTime time (0) not null,
    endTime time (0) not null,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

