package yarn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import yarn.domain.Yarn;





/**
 * DDL functions performed in database
 */
public class YarnDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "crafting_patterns"; 
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "password"; 
	


	public List<Object> read() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crafting_patterns", MySQL_user, MySQL_password);
			String sql = "select * from yarn";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Yarn yarn = new Yarn();
				yarn.yarn_id = resultSet.getString("yarn_id");
				yarn.weight = resultSet.getString("weight");
				yarn.yardage = resultSet.getString("yardage");
				yarn.fiber = resultSet.getString("fiber");
				yarn.recommended_hook_size = resultSet.getString("recommended_hook_size");
				yarn.recommended_needle_size = resultSet.getString("recommended_needle_size");
				yarn.name = resultSet.getString("name");
				yarn.manufacturer = resultSet.getString("manufacturer");

	    		list.add(yarn);
			 }
			connect.close();
		} catch(SQLException e) {
			System.out.println("Error in initializing database");
			throw new RuntimeException(e);
		}
		System.out.println(list);
		return list;

	}

	private void extracted(Connection connect, String sql3) throws SQLException {
		PreparedStatement preparestatement3 = connect.prepareStatement(sql3); 
		System.out.println(preparestatement3.executeUpdate()+" statement 4");
	}	
}
