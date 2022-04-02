package init.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import user.domain.User;



/**
 * DDL functions performed in database
 */
public class InitDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "crafting_patterns";  //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "password";  //TODO change password
	
	/**

	
	
	/**
	 * insert User
	 */
	public void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/patterns", MySQL_user, MySQL_password);
			//1
			String sql1 = "CREATE DATABASE IF NOT EXISTS patterns;";
			PreparedStatement preparestatement1 = connect.prepareStatement(sql1); 
		    preparestatement1.executeUpdate();
		    //2
			String sql2 = "use patterns;";
			PreparedStatement preparestatement2 = connect.prepareStatement(sql2); 
		    preparestatement2.executeUpdate();
		    // 3
			String sql3 = "DROP TABLE IF EXISTS user;\r\n"
					+ "DROP TABLE IF EXISTS entity1;\r\n"
					+ "DROP TABLE IF EXISTS knitting_pattern_yarn;\r\n"
					+ "DROP TABLE IF EXISTS crochet_pattern_yarn;\r\n"
					+ "DROP TABLE IF EXISTS crochet_pattern;\r\n"
					+ "DROP TABLE IF EXISTS knitting_pattern;\r\n"
					+ "DROP TABLE IF EXISTS pattern_author;\r\n"
					+ "DROP TABLE IF EXISTS yarn;";
			PreparedStatement preparestatement3 = connect.prepareStatement(sql3); 
		    preparestatement3.executeUpdate();
		    
			String sql4 = "CREATE TABLE yarn (\r\n"
					+ "	yarn_id INT auto_increment,\r\n"
					+ "    weight INT NOT NULL,\r\n"
					+ "    yardage INT,\r\n"
					+ "    fiber VARCHAR(45),\r\n"
					+ "    recommended_hook_size DOUBLE,\r\n"
					+ "    recommended_needle_size DOUBLE,\r\n"
					+ "    name VARCHAR(45),\r\n"
					+ "    manufacturer VARCHAR(45),\r\n"
					+ "    PRIMARY KEY (yarn_id)\r\n"
					+ "    );";
			PreparedStatement preparestatement4 = connect.prepareStatement(sql4); 
		    preparestatement4.executeUpdate();
		    
			String sql5 = "INSERT INTO `yarn` (`yarn_id`, `weight`, `yardage`, `fiber`, `recommended_hook_size`, `recommended_needle_size`, `name`, `manufacturer`) VALUES (1,2,2,'long',1,1,'Big thing','Sears'),(2,5,2,'Brown',0.5,0.5,'CatDog','UIC'),(3,4,4,'Yellow',1.3,1,'Kitten','UIUC'),(4,5,5,'Blue',1.9,1.3,'Adam','BigBrand'),(5,2,4,'Gray',1,1,'Wow','Yes');\r\n"
					+ "CREATE TABLE pattern_author  (\r\n"
					+ "	author_id INT auto_increment,\r\n"
					+ "    full_name VARCHAR(45),\r\n"
					+ "    userLanguage VARCHAR(45),\r\n"
					+ "    date_joined DATE,\r\n"
					+ "    primary key (author_id)\r\n"
					+ "    );\r\n"
					+ "INSERT INTO `pattern_author` (`author_id`, `full_name`, `userLanguage`, `date_joined`) VALUES (1,'Drake Shane','English','2012-02-15'),(2,'Carmela Soprano','Italian','2017-10-30'),(3,'Clifford Redding','Woof','2019-05-28'),(4,'Blake Mane','Englando','2001-01-02'),(5,'Takanashi Kiara','Japanese','2003-06-04');\r\n"
					+ "CREATE TABLE knitting_pattern (\r\n"
					+ "	pattern_id INT,\r\n"
					+ "    pattern_link VARCHAR(45) UNIQUE,\r\n"
					+ "    needle_size INT,\r\n"
					+ "    category VARCHAR(45),\r\n"
					+ "    author_id INT,\r\n"
					+ "    PRIMARY KEY (pattern_id),\r\n"
					+ "    FOREIGN KEY (author_id) REFERENCES pattern_author (author_id)\r\n"
					+ "	ON DELETE SET NULL\r\n"
					+ "	ON UPDATE CASCADE\r\n"
					+ "    );\r\n"
					+ "INSERT INTO `knitting_pattern` (`pattern_id`, `pattern_link`, `needle_size`, `category`, `author_id`) VALUES (1,'www.knittingpaternlink.com',5,'shawl',1),(2,'www.google.com',1,'Yarnlike',2),(3,'www.links.com',1,'Wow',2),(4,'www.youtube.com',1,'Animaru',4),(5,'imgur.com',1,'Helicopter',4),(6,'pngstorm.com',3,'Fourchan',3),(7,'auugh.com',2,'Blue',3);\r\n"
					+ "CREATE TABLE crochet_pattern (\r\n"
					+ "	pattern_id INT,\r\n"
					+ "    pattern_link VARCHAR(45) unique,\r\n"
					+ "    hook_size DOUBLE CONSTRAINT sizecheck CHECK (hook_size >= 0),\r\n"
					+ "    author_id INT,\r\n"
					+ "    category VARCHAR(45),\r\n"
					+ "    primary key (pattern_id),\r\n"
					+ "    foreign key (author_id) references pattern_author (author_id)\r\n"
					+ "	ON DELETE CASCADE\r\n"
					+ "	ON UPDATE CASCADE\r\n"
					+ ");\r\n"
					+ "INSERT INTO `crochet_pattern` (`pattern_id`, `pattern_link`, `hook_size`, `author_id`, `category`) VALUES (1,' www.craftingdb.com/redbikini',45,1,'Swimwear'),(2,' www.craftingdb.com/blueanorak',6,2,'Jacket'),(3,' www.craftingdb.com/blackdogcoat',8,3,'Dogwear'),(4,' www.craftingdb.com/classicbeanie',9,4,'Hat'),(5,' www.craftingdb.com/simpleshawl',10,5,'Shawl'),(6,' www.craftingdb.com/anotherone',11,3,'Miscellaneous');\r\n"
					+ "CREATE TABLE crochet_pattern_yarn (\r\n"
					+ "	pattern_id INT,\r\n"
					+ "    yarn_id INT,\r\n"
					+ "    FOREIGN KEY (pattern_id) REFERENCES crochet_pattern (pattern_id)\r\n"
					+ "	ON DELETE CASCADE\r\n"
					+ "	ON UPDATE CASCADE,\r\n"
					+ "    FOREIGN KEY (yarn_id) REFERENCES yarn (yarn_id)\r\n"
					+ "	ON DELETE CASCADE\r\n"
					+ "	ON UPDATE CASCADE,\r\n"
					+ "    PRIMARY KEY(pattern_id, yarn_id)\r\n"
					+ "    );\r\n"
					+ "CREATE TABLE knitting_pattern_yarn (\r\n"
					+ "	pattern_id INT,\r\n"
					+ "    yarn_id INT,\r\n"
					+ "    FOREIGN KEY (pattern_id) REFERENCES knitting_pattern (pattern_id)\r\n"
					+ "	ON DELETE CASCADE\r\n"
					+ "	ON UPDATE CASCADE,\r\n"
					+ "    FOREIGN KEY (yarn_id) REFERENCES yarn (yarn_id)\r\n"
					+ "	ON DELETE CASCADE\r\n"
					+ "	ON UPDATE CASCADE,\r\n"
					+ "    PRIMARY KEY(pattern_id, yarn_id)\r\n"
					+ ");\r\n"
					+ "CREATE TABLE user (\r\n"
					+ "  username varchar(50) NOT NULL,\r\n"
					+ "  password varchar(50) NOT NULL,\r\n"
					+ "  email varchar(50) NOT NULL,\r\n"
					+ "  PRIMARY KEY (username)\r\n"
					+ ");\r\n"
					+ "INSERT INTO `user` (`username`, `password`, `email`) VALUES ('adam','1','aciuri2@uic.edu'),('Edelgard','Hresvelkg','empire@gmail.com'),('Gawr','Gura','hololive@en.com'),('martina','1','idk@lol.com'),('no','yes','ok@gmail.com'),('yes','no','me@gmail.com');\r\n"
					+ "CREATE TABLE entity1 (\r\n"
					+ "  username varchar(50) NOT NULL,\r\n"
					+ "  password varchar(50) NOT NULL,\r\n"
					+ "  email varchar(50) NOT NULL,\r\n"
					+ "  PRIMARY KEY (username)\r\n"
					+ ");\r\n"
					+ "INSERT INTO `entity1` (`username`, `password`, `email`) VALUES ('adam','1','aciuri2@uic.edu'),('Edelgard','Hresvelkg','empire@gmail.com'),('Gawr','Gura','hololive@en.com'),('martina','1','idk@lol.com'),('no','yes','ok@gmail.com'),('yes','no','me@gmail.com');\r\n";
			PreparedStatement preparestatement5 = connect.prepareStatement(sql5); 
		    preparestatement5.executeUpdate();
//		    
//			String sql6 = "CREATE DATABASE IF NOT EXISTS patterns;";
//			PreparedStatement preparestatement6 = connect.prepareStatement(sql6); 
//		    preparestatement6.executeUpdate();
//		    
//			String sql7 = "CREATE DATABASE IF NOT EXISTS patterns;";
//			PreparedStatement preparestatement7 = connect.prepareStatement(sql7); 
//		    preparestatement7.executeUpdate();
//		    
//			String sql8 = "CREATE DATABASE IF NOT EXISTS patterns;";
//			PreparedStatement preparestatement8 = connect.prepareStatement(sql8); 
//		    preparestatement8.executeUpdate();
		    
		    
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

		
}
