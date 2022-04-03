CREATE DATABASE IF NOT EXISTS crafting_patterns;
use crafting_patterns;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS entity1;
DROP TABLE IF EXISTS knitting_pattern_yarn;
DROP TABLE IF EXISTS crochet_pattern_yarn;
DROP TABLE IF EXISTS crochet_pattern;
DROP TABLE IF EXISTS knitting_pattern;
DROP TABLE IF EXISTS pattern_author;
DROP TABLE IF EXISTS yarn;

CREATE TABLE yarn (
	yarn_id INT auto_increment,
    weight INT NOT NULL,
    yardage INT,
    fiber VARCHAR(45),
    recommended_hook_size DOUBLE,
    recommended_needle_size DOUBLE,
    name VARCHAR(45),
    manufacturer VARCHAR(45),
    PRIMARY KEY (yarn_id)
    );
INSERT INTO `yarn` (`yarn_id`, `weight`, `yardage`, `fiber`, `recommended_hook_size`, `recommended_needle_size`, `name`, `manufacturer`) VALUES (1,2,2,'long',1,1,'Big thing','Sears'),(2,5,2,'Brown',0.5,0.5,'CatDog','UIC'),(3,4,4,'Yellow',1.3,1,'Kitten','UIUC'),(4,5,5,'Blue',1.9,1.3,'Adam','BigBrand'),(5,2,4,'Gray',1,1,'Wow','Yes');
CREATE TABLE pattern_author  (
	author_id INT auto_increment,
    full_name VARCHAR(45),
    userLanguage VARCHAR(45),
    date_joined DATE,
    primary key (author_id)
    );
INSERT INTO `pattern_author` (`author_id`, `full_name`, `userLanguage`, `date_joined`) VALUES (1,'Drake Shane','English','2012-02-15'),(2,'Carmela Soprano','Italian','2017-10-30'),(3,'Clifford Redding','Woof','2019-05-28'),(4,'Blake Mane','Englando','2001-01-02'),(5,'Takanashi Kiara','Japanese','2003-06-04');
CREATE TABLE knitting_pattern (
	pattern_id INT,
    pattern_link VARCHAR(45) UNIQUE,
    needle_size INT,
    category VARCHAR(45),
    author_id INT,
    PRIMARY KEY (pattern_id),
    FOREIGN KEY (author_id) REFERENCES pattern_author (author_id)
	ON DELETE SET NULL
	ON UPDATE CASCADE
    );
INSERT INTO `knitting_pattern` (`pattern_id`, `pattern_link`, `needle_size`, `category`, `author_id`) VALUES (1,'www.knittingpaternlink.com',5,'shawl',1),(2,'www.google.com',1,'Yarnlike',2),(3,'www.links.com',1,'Wow',2),(4,'www.youtube.com',1,'Animaru',4),(5,'imgur.com',1,'Helicopter',4),(6,'pngstorm.com',3,'Fourchan',3),(7,'auugh.com',2,'Blue',3);
CREATE TABLE crochet_pattern (
	pattern_id INT,
    pattern_link VARCHAR(45) unique,
    hook_size DOUBLE CONSTRAINT sizecheck CHECK (hook_size >= 0),
    author_id INT,
    category VARCHAR(45),
    primary key (pattern_id),
    foreign key (author_id) references pattern_author (author_id)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);
INSERT INTO `crochet_pattern` (`pattern_id`, `pattern_link`, `hook_size`, `author_id`, `category`) VALUES (1,' www.craftingdb.com/redbikini',45,1,'Swimwear'),(2,' www.craftingdb.com/blueanorak',6,2,'Jacket'),(3,' www.craftingdb.com/blackdogcoat',8,3,'Dogwear'),(4,' www.craftingdb.com/classicbeanie',9,4,'Hat'),(5,' www.craftingdb.com/simpleshawl',10,5,'Shawl'),(6,' www.craftingdb.com/anotherone',11,3,'Miscellaneous');
CREATE TABLE crochet_pattern_yarn (
	pattern_id INT,
    yarn_id INT,
    FOREIGN KEY (pattern_id) REFERENCES crochet_pattern (pattern_id)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
    FOREIGN KEY (yarn_id) REFERENCES yarn (yarn_id)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
    PRIMARY KEY(pattern_id, yarn_id)
    );
CREATE TABLE knitting_pattern_yarn (
	pattern_id INT,
    yarn_id INT,
    FOREIGN KEY (pattern_id) REFERENCES knitting_pattern (pattern_id)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
    FOREIGN KEY (yarn_id) REFERENCES yarn (yarn_id)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
    PRIMARY KEY(pattern_id, yarn_id)
);
CREATE TABLE user (
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  PRIMARY KEY (username)
);
INSERT INTO `user` (`username`, `password`, `email`) VALUES ('adam','1','aciuri2@uic.edu'),('Edelgard','Hresvelkg','empire@gmail.com'),('Gawr','Gura','hololive@en.com'),('martina','1','idk@lol.com'),('no','yes','ok@gmail.com'),('yes','no','me@gmail.com');
CREATE TABLE entity1 (
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  PRIMARY KEY (username)
);
INSERT INTO `entity1` (`username`, `password`, `email`) VALUES ('adam','1','aciuri2@uic.edu'),('Edelgard','Hresvelkg','empire@gmail.com'),('Gawr','Gura','hololive@en.com'),('martina','1','idk@lol.com'),('no','yes','ok@gmail.com'),('yes','no','me@gmail.com');
    
