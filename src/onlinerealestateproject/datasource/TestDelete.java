package onlinerealestateproject.datasource;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import onlinerealestateproject.domain.Administrator;

public class TestDelete {

  public static void main(String[] argv) {

	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	delete(2);
  }

  

public static void delete(int a) throws DataMapperException {
	// TODO Auto-generated method stub
	try {
		Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306"
				+ "/softwarearchitecture?serverTimezone=Australia/Melbourne", "root", "123");					
			String statement = "delete from administrator where aid=?";
			PreparedStatement dbStatement = db.prepareStatement(statement);
			dbStatement.setInt(1, a);
			dbStatement.executeUpdate();
		
	} catch (SQLException e) {
		
			throw new DataMapperException( e);
	}
	
}

  
}