CREATE DATABASE IF NOT EXISTS bookstore;
use bookstore;
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
CREATE TABLE IF NOT EXISTS pattern_author  (
	author_id INT auto_increment,
    full_name VARCHAR(45),
    userLanguage VARCHAR(45),
    date_joined DATE,
    primary key (author_id)
    );
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
CREATE TABLE entity1 (
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  PRIMARY KEY (username)
);

    