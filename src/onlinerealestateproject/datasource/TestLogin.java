

package onlinerealestateproject.datasource;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import onlinerealestateproject.domain.Administrator;

public class TestLogin {
	
	

//  public static void main(String[] argv) {
//
//	System.out.println("-------- MySQL JDBC Connection Testing ------------");
//	find("steve","123");
//  }

public boolean find(String a, String b){
	try {
		int aid1=0;
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306"
//				+ "/softwarearchitecture?serverTimezone=Australia/Melbourne", "root", "123");						
		String sql = "SELECT * FROM administrator where userName='"+a+"' and password="+b;
		//PreparedStatement dbStatement = db.prepareStatement(sql);
		PreparedStatement dbStatement = MySQLConnection.prepare(sql);
		System.out.println("MySQL JDBC Driver Registered11!");
		System.out.println("MySQL JDBC Driver Registered22!");
		ResultSet rs = dbStatement.executeQuery();
		while(rs.next()) {
			aid1 = rs.getInt(1);
			System.out.println(aid1);
			String fistName = rs.getString(2);
			System.out.println(fistName);
			String lastName = rs.getString(3);
			System.out.println(lastName);
			String userName = rs.getString(4);
			System.out.println(userName);
			String password = rs.getString(5);
			System.out.println(password);
			int order = rs.getInt(5);
			String permission = rs.getString(5);	
			Administrator administrator = new Administrator(aid1, fistName, 
			lastName, userName, password, order, permission);
			administrator.setUid(aid1);
			System.out.println("id="+administrator.getUid());
			administrator.setFirstName(fistName);
			administrator.setLastName(lastName);
			administrator.setUserName(userName);
			administrator.setPassword(password);	
			administrator.setOrder(order);	
		}
		if(aid1!=0) {
			System.out.print("yes");
			return true;
		}
		else {
			System.out.print("No");
			return false;
		}
	}	
	catch (SQLException e) {
		throw new DataMapperException(e);
	}
	
	
}
  

	

  
}