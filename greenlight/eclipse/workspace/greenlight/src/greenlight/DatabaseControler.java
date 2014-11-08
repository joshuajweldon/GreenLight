package greenlight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseControler {
	
	Connection connection;
	ResultSet  resultSet;
	
	public DatabaseControler(){
		
		String url = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://173.194.252.106:3306?user=root";
			
	
			connection = DriverManager.getConnection(url,"root","StrongHtr&7");
			resultSet = connection.createStatement().executeQuery("use greenlight");
	
			resultSet.close();
		}
		catch(SQLException e){System.err.println("DatabaseControler.DatabaseControler could not connect to database");}
		catch(ClassNotFoundException c){System.err.println("DatabaseControler.DatabaseControler could not find class");}
		
	}
	
	public boolean runInsertQuery(String query){
		
		System.out.println(query);
		try {connection.createStatement().execute(query); System.out.println("ok?");resultSet.close();} 
		catch (SQLException e) {System.out.println(e.getMessage());return false;}
		
		return true;
		
	}
	
	public void testMethod() throws ClassNotFoundException, SQLException{

		
		resultSet = connection.createStatement().executeQuery("select * from users");

		while(resultSet.next()){
		int    id = resultSet.getInt("id");
		String fn = resultSet.getString("first_name");
		String ln = resultSet.getString("last_name");
		String ct = resultSet.getString("phone_number");

		System.out.println("id: " + id + " | fn: " + fn + " | ln: "+ ln + " | ct: " + ct);
		}
		
		resultSet.close();
	}
}