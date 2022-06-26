DROP schema IF EXISTS authentication;

CREATE database IF NOT EXISTS authentication;

use authentication;
CREATE TABLE IF NOT EXISTS USER(
       ID bigint not null auto_increment,
       EMAIL varchar(255) not null,
       FIRST_NAME varchar(255) not null,
       MIDDLE_NAME varchar(255) default null,
       LAST_NAME varchar(255) not null,
       PASSWORD varchar(255) not null,
       CREATED_TIMESTAMP timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
       MODIFIED_TIMESTAMP timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
       PRIMARY KEY (ID),
       UNIQUE (EMAIL)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8MB4;

INSERT INTO USER (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD) VALUES
    ('pinkelgrg@gmail.com','Pinkel', 'Gurung', '$2a$10$Sac2O1d7LY8rHL661dV7uOia0M0FRq4le1tdddNzCrz3ODycF0/W.');
-- $2a$10$Sac2O1d7LY8rHL661dV7uOia0M0FRq4le1tdddNzCrz3ODycF0/W. = mypassword