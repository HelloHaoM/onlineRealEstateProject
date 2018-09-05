package onlinerealestateproject.datasource;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import onlinerealestateproject.domain.Administrator;

public class TestFind {

  public static void main(String[] argv) {

	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	find(2);
  }

public static void find(int a){
	try {
		String sql = "SELECT * FROM administrator where Aid="+a;
		MySQLConnection mysqlconnection = new MySQLConnection();
		mysqlconnection.getDBConnection();
		mysqlconnection.prepare(sql);
		System.out.println("MySQL JDBC Driver Registered11!");
		System.out.println("MySQL JDBC Driver Registered22!");
		ResultSet rs = mysqlconnection.prepare(sql).executeQuery();

		while(rs.next()) {
			int aid1 = rs.getInt(1);
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
		
	}
	
	 catch (SQLException e) {
		
		throw new DataMapperException(e);
	}

	
}
  

	

  
}