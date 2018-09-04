package onlinerealestateproject.datasource;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import onlinerealestateproject.domain.Administrator;

public class TestUpdate {

  public static void main(String[] argv) {

	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	update(2,"s","a","s","123");
  }

public static void update(int a, String string, String string2, String string3, String string4){
	try {
		Administrator administrator = new Administrator(a, string, string2, string3, string4,a,string4);
		Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306"
				+ "/softwarearchitecture?serverTimezone=Australia/Melbourne", "root", "123");						
		String sql = "update administrator set aid=?, firstName=?, lastName=?, userName=?,password=? where Aid="+a;
		PreparedStatement dbStatement = db.prepareStatement(sql);
		System.out.println("MySQL JDBC Driver Registered11!");
//		dbStatement.setLong(1, '1');
		System.out.println("MySQL JDBC Driver Registered22!");

		dbStatement.setInt(1, administrator.getUid());
		dbStatement.setString(2, administrator.getFirstName());
		dbStatement.setString(3, administrator.getLastName());
		dbStatement.setString(4, administrator.getUserName());
		dbStatement.setString(5, administrator.getPassword());
		dbStatement.setInt(4, administrator.getOrder());		
		dbStatement.executeUpdate();
	}
	
	 catch (SQLException e) {
		
		throw new DataMapperException(e);
	}

}

}