package onlinerealestateproject.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Make an singleton db connection
 * @author haomai
 *
 */
public class MySQLConnection {
	private static MySQLConnection singleMySQLConnection = new MySQLConnection();
	private Connection dbConnection;
	private int count;
	
	public static final String SQL_URL = "jdbc:postgresql://localhost:5432/postgres";
			//"jdbc:postgresql://ec2-107-21-98-165.compute-1.amazonaws.com:5432/d102mvg3lomse";
			//"jdbc:mysql://localhost:3306/onlineRealEstate?serverTimezone=Australia/Melbourne";
	public static final String USER_NAME = "postgres";
	//"vyvqoseqjkvkge";
	public static final String PASSWORD = "";
	//"5eea646076c4e537db7c4167fc1585437bf105fe6c8bf484220d93c98b6cb232";
	
	private MySQLConnection() {
		//this.dbConnection = this.getDBConnection();
		count++;
		//System.out.println("Add one Connection");
	}
	
	public static MySQLConnection getSingleMySQLConnection() {
		if(singleMySQLConnection == null)
			singleMySQLConnection = new MySQLConnection();
		return singleMySQLConnection;
	}
	
	public Connection getConnection() {
		//this.dbConnection = this.getConnection();
		System.out.println("Connection Established");
		return dbConnection;
	}
	
	public void closeConnection() {
		try {
			if(this.dbConnection != null) {
				this.dbConnection.close();
				System.out.println("Connection Closed");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// Get a mysql connection
	public void establishDBConnection() {
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
			this.dbConnection = connection;
			System.out.println("DB Connect Successfully");

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
