package onlinerealestateproject.datasource;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import onlinerealestateproject.domain.Administrator;

public class TestInsert {

  public static void main(String[] argv) {

	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	insert(55,"steve","aoki","steve","123");


  }

private static void insert(int i, String string, String string2, String string3, String string4) {
	// TODO Auto-generated method stub
	try {
		Administrator administrator = new Administrator(i, string, string2, string3, string4,i,string4);
		Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306/softwarearchitecture?serverTimezone=Australia/Melbourne", "root", "123");					
		String statement = "insert into administrator (aid, firstName, lastName, userName, password)  values (?, ?, ?, ?, ?)";
		System.out.println("hello");
		PreparedStatement dbStatement = db.prepareStatement(statement);
		System.out.println(dbStatement);
		dbStatement.setInt(1, i);
		dbStatement.setString(2, string);
		dbStatement.setString(3, string2);
		dbStatement.setString(4, string3);
		dbStatement.setString(5, string4);		
		dbStatement.executeUpdate();
	
} catch (SQLException e) {
	 
		throw new DataMapperException( e);
}
}	
	

  
}