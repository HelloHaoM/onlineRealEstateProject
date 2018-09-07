

package onlinerealestateproject.util;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import onlinerealestateproject.datasource.DataMapperException;
import onlinerealestateproject.datasource.MySQLConnection;
import onlinerealestateproject.domain.Administrator;
/**
 * @author Junjie Huang
 * 
 */
public class ToolLogin {
	
	

//  public static void main(String[] argv) {
//
//	System.out.println("-------- MySQL JDBC Connection Testing ------------");
//	find("steve","123");
//  }
 
public boolean find(String a, String b){
	try {
		int aid1=0;
		MySQLConnection mysqlconnection = new MySQLConnection();
		mysqlconnection.getDBConnection();
		String statement = "SELECT * FROM administrator where userName='"+a+"' and password="+b;
		PreparedStatement dbStatement = MySQLConnection.prepare(statement);
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
			String permission = rs.getString(5);	
			Administrator administrator = new Administrator(aid1, fistName, 
			lastName, userName, password, order, permission);
			administrator.setUid(aid1);			
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