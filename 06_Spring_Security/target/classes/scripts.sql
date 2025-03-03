create database bankdb;

use bankdb;


-- Step 1 - Using Spring Default Table Structure 
-- org/springframework/security/core/userdetails/jdbc/users.ddl

create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

insert ignore into users values('user','{noop}Bahubali@2010','1');
insert ignore into authorities values('user','read');

insert ignore into users values('admin','{bcrypt}$2a$12$DH3h3C7QyaniWhsTKfgv3u4b9p8Vnimt5cwsMIvimBFUADSZmeBda','1');
insert ignore into authorities values('admin','admin');

commit;

select * from users;

-- setting password = Ofss@72025
update users set password='{bcrypt}$2a$12$MaRfCGLQQStTX2uDL6xbmuKu0ndtjsTPlKOhHYhrUn5uvR4wg.lbe' where username = 'admin';
update users set password='{noop}Bahubali@2025' where username = 'user';

-- Step 2 - Creating Custom Tables
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `pwd` varchar(200) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT  INTO `customer` (`email`, `pwd`, `role`) VALUES ('happy@example.com', '{noop}Bahubali@2025', 'read');
INSERT  INTO `customer` (`email`, `pwd`, `role`) VALUES ('admin@example.com', '{bcrypt}$2a$12$MaRfCGLQQStTX2uDL6xbmuKu0ndtjsTPlKOhHYhrUn5uvR4wg.lbe', 'admin');