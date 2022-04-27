package yarn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import user.domain.User;
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
	
	public void add(Yarn yarn) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crafting_patterns", MySQL_user, MySQL_password);
			
			String sql = "insert into yarn values(?,?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,yarn.get1());
		    preparestatement.setString(2,yarn.get2());
		    preparestatement.setString(3,yarn.get3());
		    preparestatement.setString(4,yarn.get4());
		    preparestatement.setString(5,yarn.get5());
		    preparestatement.setString(6,yarn.get6());
		    preparestatement.setString(7,yarn.get7());
		    preparestatement.setString(8,yarn.get8());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Yarn yarn) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crafting_patterns", MySQL_user, MySQL_password);
			
			String sql = "insert into yarn values(?,?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,yarn.get1());
		    preparestatement.setString(2,yarn.get2());
		    preparestatement.setString(3,yarn.get3());
		    preparestatement.setString(4,yarn.get4());
		    preparestatement.setString(5,yarn.get5());
		    preparestatement.setString(6,yarn.get6());
		    preparestatement.setString(7,yarn.get7());
		    preparestatement.setString(8,yarn.get8());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Object> delete(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("why is this like this: " +id);
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crafting_patterns", MySQL_user, MySQL_password);
			String sql1 = "select * from yarn where yarn_id =  (?)";
			PreparedStatement preparestatement1 = connect.prepareStatement(sql1);
			
			preparestatement1.setString(1,id);
			System.out.println(preparestatement1);
			ResultSet resultSet = preparestatement1.executeQuery();		
			System.out.println("YarnDao resultSet: "+resultSet);
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
			String sql = "delete from yarn where yarn_id =  (?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
//			String[] myInt = id.split(".");
//			System.out.println("why is this like this: " +id);
			System.out.println(id);

			preparestatement.setString(1,id);
			
		    preparestatement.executeUpdate();
		    

		    connect.close();
		    return list;

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

	private void extracted(Connection connect, String sql3) throws SQLException {
		PreparedStatement preparestatement3 = connect.prepareStatement(sql3); 
		System.out.println(preparestatement3.executeUpdate()+" statement 4");
	}	
}
