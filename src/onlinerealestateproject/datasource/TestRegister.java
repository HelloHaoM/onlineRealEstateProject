package onlinerealestateproject.datasource;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import onlinerealestateproject.domain.Administrator;

public class TestRegister {

  public static void main(String[] argv) {

	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	find("steve");
  }

public static boolean find(String a){
	try {
		int aid1=0;
		Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306"
				+ "/softwarearchitecture?serverTimezone=Australia/Melbourne", "root", "123");						
		String sql = "SELECT * FROM administrator where username='"+a+"'";
		PreparedStatement dbStatement = db.prepareStatement(sql);
		System.out.println("MySQL JDBC Driver Registered11!");
//		dbStatement.setLong(1, '1');
		System.out.println("MySQL JDBC Driver Registered22!");
		ResultSet rs = dbStatement.executeQuery();
//		System.out.println(rs);
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
//			System.out.println(order);
			String permission = rs.getString(5);	
//			System.out.println(permission);
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
			System.out.print("no, username existed");
			
			return false;
		}
		else {
			System.out.print("yes, username is available");
			return true;
		}

		
	}
	
	 catch (SQLException e) {
		
		throw new DataMapperException(e);
	}

	
}

public static void insert(int i, String string, String string2, String string3, String string4) {
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