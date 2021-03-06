package init.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;





/**
 * DDL functions performed in database
 */
public class InitDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "crafting_patterns"; 
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "password"; 
	


	public void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crafting_patterns", MySQL_user, MySQL_password);

			extracted(connect, "DROP TABLE IF EXISTS user; ");
			extracted(connect, "DROP TABLE IF EXISTS entity1; ");
			extracted(connect, "DROP TABLE IF EXISTS knitting_pattern_yarn; ");
			extracted(connect, "DROP TABLE IF EXISTS crochet_pattern_yarn; ");
			extracted(connect, "DROP TABLE IF EXISTS crochet_pattern; ");
			extracted(connect, "DROP TABLE IF EXISTS knitting_pattern; ");
			extracted(connect, "DROP TABLE IF EXISTS pattern_author; ");
			extracted(connect, "DROP TABLE IF EXISTS yarn; ");
		    extracted(connect, "DROP TABLE IF EXISTS yarn; ");
		    
		    extracted(connect, "CREATE TABLE yarn (\n" +
		    "	yarn_id INT auto_increment,\n" +
		    "    weight INT NOT NULL,\n" +
		    "    yardage INT,\n" +
		    "    fiber VARCHAR(45),\n" +
		    "    recommended_hook_size DOUBLE,\n" +
		    "    recommended_needle_size DOUBLE,\n" +
		    "    name VARCHAR(45),\n" +
		    "    manufacturer VARCHAR(45),\n" +
		    "    PRIMARY KEY (yarn_id)\n" +
		    "    );\n");
		    extracted(connect, "INSERT INTO `yarn` (`yarn_id`, `weight`, `yardage`, `fiber`, `recommended_hook_size`, `recommended_needle_size`, `name`, `manufacturer`) VALUES (1,2,2,'long',1,1,'Big thing','Sears'),(2,5,2,'Brown',0.5,0.5,'CatDog','UIC'),(3,4,4,'Yellow',1.3,1,'Kitten','UIUC'),(4,5,5,'Blue',1.9,1.3,'Adam','BigBrand'),(5,2,4,'Gray',1,1,'Wow','Yes');\n");
		    extracted(connect, "CREATE TABLE pattern_author (" +
		    "	author_id INT auto_increment,\n" +
		    "    full_name VARCHAR(45),\n" +
		    "    user_language VARCHAR(45),\n" +
		    "    date_joined DATE,\n" +
		    "    primary key (author_id)\n" +
		    "    );\n" );
		    extracted(connect, "INSERT INTO `pattern_author` (`author_id`, `full_name`, `user_language`, `date_joined`) VALUES (1,'Drake Shane','English','2012-02-15'),(2,'Carmela Soprano','Italian','2017-10-30'),(3,'Clifford Redding','Woof','2019-05-28'),(4,'Blake Mane','Englando','2001-01-02'),(5,'Takanashi Kiara','Japanese','2003-06-04');\n");
		    extracted(connect, "CREATE TABLE knitting_pattern (\n" +
		    "	pattern_id INT,\n" +
		    "    pattern_link VARCHAR(45) UNIQUE,\n" +
		    "    needle_size INT,\n" +
		    "    category VARCHAR(45),\n" +
		    "    author_id INT,\n" +
		    "    PRIMARY KEY (pattern_id),\n" +
		    "    FOREIGN KEY (author_id) REFERENCES pattern_author (author_id)\n" +
		    "	ON DELETE SET NULL\n" +
		    "	ON UPDATE CASCADE\n" +
		    "    );\n");
		    extracted(connect, "INSERT INTO `knitting_pattern` (`pattern_id`, `pattern_link`, `needle_size`, `category`, `author_id`) VALUES (1,'www.knittingpaternlink.com',5,'shawl',1),(2,'www.google.com',1,'Yarnlike',2),(3,'www.links.com',1,'Wow',2),(4,'www.youtube.com',1,'Animaru',4),(5,'imgur.com',1,'Helicopter',4),(6,'pngstorm.com',3,'Fourchan',3),(7,'auugh.com',2,'Blue',3);\n");
		    extracted(connect,"CREATE TABLE crochet_pattern (\n" +
		    "	pattern_id INT,\n" +
		    "    pattern_link VARCHAR(45) unique,\n" +
		    "    hook_size DOUBLE CONSTRAINT sizecheck CHECK (hook_size >= 0),\n" +
		    "    author_id INT,\n" +
		    "    category VARCHAR(45),\n" +
		    "    primary key (pattern_id),\n" +
		    "    foreign key (author_id) references pattern_author (author_id)\n" +
		    "	ON DELETE CASCADE\n" +
		    "	ON UPDATE CASCADE\n" +
		    ");\n");
		    extracted(connect, "INSERT INTO `crochet_pattern` (`pattern_id`, `pattern_link`, `hook_size`, `author_id`, `category`) VALUES (1,' www.craftingdb.com/redbikini',45,1,'Swimwear'),(2,' www.craftingdb.com/blueanorak',6,2,'Jacket'),(3,' www.craftingdb.com/blackdogcoat',8,3,'Dogwear'),(4,' www.craftingdb.com/classicbeanie',9,4,'Hat'),(5,' www.craftingdb.com/simpleshawl',10,5,'Shawl'),(6,' www.craftingdb.com/anotherone',11,3,'Miscellaneous');\n");
		    extracted(connect, "CREATE TABLE crochet_pattern_yarn (\n" +
		    "	pattern_id INT,\n" +
		    "    yarn_id INT,\n" +
		    "    FOREIGN KEY (pattern_id) REFERENCES crochet_pattern (pattern_id)\n" +
		    "	ON DELETE CASCADE\n" +
		    "	ON UPDATE CASCADE,\n" +
		    "    FOREIGN KEY (yarn_id) REFERENCES yarn (yarn_id)\n" +
		    "	ON DELETE CASCADE\n" +
		    "	ON UPDATE CASCADE,\n" +
		    "    PRIMARY KEY(pattern_id, yarn_id)\n" +
		    "    );\n");
		    extracted(connect, "CREATE TABLE knitting_pattern_yarn (\n" +
		    "	pattern_id INT,\n" +
		    "    yarn_id INT,\n" +
		    "    FOREIGN KEY (pattern_id) REFERENCES knitting_pattern (pattern_id)\n" +
		    "	ON DELETE CASCADE\n" +
		    "	ON UPDATE CASCADE,\n" +
		    "    FOREIGN KEY (yarn_id) REFERENCES yarn (yarn_id)\n" +
		    "	ON DELETE CASCADE\n" +
		    "	ON UPDATE CASCADE,\n" +
		    "    PRIMARY KEY(pattern_id, yarn_id)\n" +
		    ");\n");
		    extracted(connect, "CREATE TABLE user (\n" +
		    "  username varchar(50) NOT NULL,\n" +
		    "  password varchar(50) NOT NULL,\n" +
		    "  email varchar(50) NOT NULL,\n" +
		    "  PRIMARY KEY (username)\n" +
		    ");\n");
		    extracted(connect, "INSERT INTO `user` (`username`, `password`, `email`) VALUES ('adam','1','aciuri2@uic.edu'),('Edelgard','Hresvelkg','empire@gmail.com'),('Gawr','Gura','hololive@en.com'),('martina','1','idk@lol.com'),('no','yes','ok@gmail.com'),('yes','no','me@gmail.com');\n");
		    extracted(connect, "CREATE TABLE entity1 (\n" +
		    "  username varchar(50) NOT NULL,\n" +
		    "  password varchar(50) NOT NULL,\n" +
		    "  email varchar(50) NOT NULL,\n" +
		    "  PRIMARY KEY (username)\n" +
		    ");\n");
		    extracted(connect, "INSERT INTO `entity1` (`username`, `password`, `email`) VALUES ('adam','1','aciuri2@uic.edu'),('Edelgard','Hresvelkg','empire@gmail.com'),('Gawr','Gura','hololive@en.com'),('martina','1','idk@lol.com'),('no','yes','ok@gmail.com'),('yes','no','me@gmail.com');\n");    
		    
		    connect.close();
		} catch(SQLException e) {
			System.out.println("Error in initializing database");
			throw new RuntimeException(e);
		}
	}

	private void extracted(Connection connect, String sql3) throws SQLException {
		PreparedStatement preparestatement3 = connect.prepareStatement(sql3); 
		System.out.println(preparestatement3.executeUpdate()+" statement 4");
	}	
}
