import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnection {
	public static final String  SQL_URL = "jdbc:mysql://localhost:3306/onlineRealEstate?serverTimezone=Australia/Melbourne";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("MySql Driver Loading Successful");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection connect = DriverManager.getConnection(SQL_URL, "root", "19950110maihao");
			Statement statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user");
			while (resultSet.next()) {
				System.out.println(resultSet.getString("name"));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
