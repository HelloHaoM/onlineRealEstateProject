package onlinerealestateproject.datasource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
	public static final String SQL_URL = "jdbc:postgresql://localhost:5432/postgres";
			//"jdbc:postgresql://ec2-107-21-98-165.compute-1.amazonaws.com:5432/d102mvg3lomse";
			//"jdbc:mysql://localhost:3306/onlineRealEstate?serverTimezone=Australia/Melbourne";
	public static final String USER_NAME = "postgres";
	//"vyvqoseqjkvkge";
	public static final String PASSWORD = "";
	//"5eea646076c4e537db7c4167fc1585437bf105fe6c8bf484220d93c98b6cb232";
	
	public static PreparedStatement prepare(String stm) {
		 
		PreparedStatement preparedStatement = null;
		try {	
	
	       	Connection dbConnection = getDBConnection();
				
			preparedStatement = dbConnection.prepareStatement(stm);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		
		}

		return preparedStatement;
	} 
	
	
	// Get a mysql connection
	public static Connection getDBConnection() {
		// TODO Auto-generated method stub
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("org.postgresql.Driver");
			
			System.out.println("MySql Driver Loading Successful");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(SQL_URL, USER_NAME, PASSWORD);
//			Statement statement = connect.createStatement();
//			ResultSet resultSet = statement.executeQuery("select * from user");
//			while (resultSet.next()) {
//				System.out.println(resultSet.getString("name"));
//			}
			System.out.println("DB Connect Successfully");
			return connection;

		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String args[]) {
		MySQLConnection.prepare("select * from users");
	}

}
