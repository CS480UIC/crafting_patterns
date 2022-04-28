package pattern_author.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;




//import java.util.ArrayList;
//import java.util.List;

import pattern_author.domain.PatternAuthor;

/**
 * DDL functions performed in database
 */
public class PatternAuthorDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "crafting_patterns"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "password"; //TODO change password

	public PatternAuthor findByAuthorId(Integer author_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		PatternAuthor author = new PatternAuthor();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crafting_patterns", MySQL_user, MySQL_password);
		    String sql = "select * from pattern_author where author_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,author_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer id = Integer.parseInt(resultSet.getString("author_id"));
		    	if(id.equals(author_id)){
		    		author.setAuthor_id(id);
		    		author.setDate_joined(java.sql.Date.valueOf(resultSet.getString("date_joined")));
		    		author.setFull_name(resultSet.getString("full_name"));
		    		author.setUser_Language(resultSet.getString("user_language"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return author;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(PatternAuthor form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crafting_patterns", MySQL_user, MySQL_password);
			
			String sql = "insert into pattern_author (author_id, full_name, user_language, date_joined) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getAuthor_id());
		    preparestatement.setString(2,form.getFull_name());
		    preparestatement.setString(3,form.getUser_Language());
		    preparestatement.setDate(4,form.getDate_joined());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(PatternAuthor form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crafting_patterns", MySQL_user, MySQL_password);
//			
//			String sql = "UPDATE entity1 SET password = ?, email = ? where username = ?;";
//			PreparedStatement preparestatement = connect.prepareStatement(sql); 
//		    preparestatement.setString(1,form.getPassword());
//			preparestatement.setString(2,form.getEmail());
//		    preparestatement.setString(3,form.getUsername());
//		    preparestatement.executeUpdate();
//		    connect.close();
//		} catch(SQLException e) {
//			throw new RuntimeException(e);
//		}
	}
	
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crafting_patterns", MySQL_user, MySQL_password);
//			
//			String sql = "delete from entity1 where username = ?";
//			PreparedStatement preparestatement = connect.prepareStatement(sql); 
//		    preparestatement.setString(1,username);
//		    preparestatement.executeUpdate();
//		    connect.close();
//		} catch(SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
}
}
