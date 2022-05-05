package crochet_pattern.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import crochet_pattern.domain.Crochet_pattern;

/**
 * DDL functions performed in database
 */
public class Crochet_patternDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "crafting_patterns"; 
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "password"; //TODO change password

	public Crochet_pattern findBypattern_id(Integer pattern_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Crochet_pattern crochet_pattern = new Crochet_pattern();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crafting_patterns", MySQL_user, MySQL_password);
		    String sql = "select* from crochet_pattern where pattern_id = ? ";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,pattern_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer id = resultSet.getInt("author_id");
		    	if(id.equals(pattern_id)){
		    		crochet_pattern.setAuthor_id(Integer.parseInt(resultSet.getString("author_id")));
		    		crochet_pattern.setCategory(resultSet.getString("category"));
		    		crochet_pattern.setHook_size(Double.parseDouble(resultSet.getString("hook_size")));
		    		crochet_pattern.setPattern_link(resultSet.getString("pattern_link"));
		    		crochet_pattern.setPattern_id(Integer.parseInt(resultSet.getString("pattern_id"))); 
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return crochet_pattern;
	}	
	
	/**
	 * insert crochet_pattern
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Crochet_pattern form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crafting_patterns", MySQL_user, MySQL_password);
			
			String sql = "insert into crochet_pattern (pattern_id, pattern_link, hook_size, author_id, category) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getPattern_id());
		    preparestatement.setString(2,form.getPattern_link());
		    preparestatement.setDouble(3,form.getHook_size());
		    preparestatement.setInt(4,form.getAuthor_id());
		    preparestatement.setString(5,form.getCategory());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * update crochet_pattern
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Crochet_pattern form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crafting_patterns", MySQL_user, MySQL_password);
			Integer id = form.getPattern_id();
			String sql = "UPDATE crochet_pattern SET pattern_link = ?, hook_size = ?, author_id = ?, category = ? WHERE pattern_id = " + id + ";";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(1,form.getPattern_link());
		    preparestatement.setDouble(2,form.getHook_size());
		    preparestatement.setInt(3,form.getAuthor_id());
		    preparestatement.setString(4,form.getCategory());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param pattern_id
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String pattern_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crafting_patterns", MySQL_user, MySQL_password);
			
			String sql = "delete from crochet_pattern where pattern_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(pattern_id));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
