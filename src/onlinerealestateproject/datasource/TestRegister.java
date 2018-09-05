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
		MySQLConnection mysqlconnection = new MySQLConnection();
		mysqlconnection.getDBConnection();						
		String statement = "SELECT * FROM administrator where username='"+a+"'";
		PreparedStatement dbStatement = mysqlconnection.prepare(statement);
		System.out.println("MySQL JDBC Driver Registered11!");
		System.out.println("MySQL JDBC Driver Registered22!");
		ResultSet rs = dbStatement.executeQuery();
		while(rs.next()) {
			aid1 = rs.getInt(1);
			String fistName = rs.getString(2);
			String lastName = rs.getString(3);
			String userName = rs.getString(4);
			String password = rs.getString(5);
			int order = rs.getInt(5);
			String permission = rs.getString(5);				Administrator administrator = new Administrator(aid1, fistName, 
			lastName, userName, password, order, permission);
			administrator.setUid(aid1);
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
		MySQLConnection mysqlconnection = new MySQLConnection();
		mysqlconnection.getDBConnection();
		String statement = "insert into administrator ( firstName, lastName, userName, password)  values (?, ?, ?, ?, ?)";
		System.out.println("hello");
		PreparedStatement dbStatement = mysqlconnection.prepare(statement);
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