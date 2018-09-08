package onlinerealestateproject.util;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import onlinerealestateproject.datasource.DataMapperException;
import onlinerealestateproject.datasource.MySQLConnection;
import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Client;
/**
 * @author Junjie Huang
 * 
 */
public class ToolRegister {

//  public static void main(String[] argv) {
//
//	System.out.println("-------- MySQL JDBC Connection Testing ------------");
//	find("steve");
//	insert(0,"rocket","aoki","k","123",3,"no","client");
//  }

public static boolean find(String a){
	try {
		int aid1=0;
//		MySQLConnection mysqlconnection = new MySQLConnection();
//		mysqlconnection.getDBConnection();						
		String statement = "SELECT * FROM client where firstname='"+a+"'";
		PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(statement);
		System.out.println("MySQL JDBC Driver Registered11!");
		System.out.println("MySQL JDBC Driver Registered22!");
		ResultSet rs = dbStatement.executeQuery();
		while(rs.next()) {
			aid1 = rs.getInt(1);
			String fistName = rs.getString(2);
			String lastName = rs.getString(3);
			String userName = rs.getString(4);
			String password = rs.getString(5);
			int order = rs.getInt(6);
			String permission = rs.getString(7);				
			Client client = new Client(aid1, fistName, 
			lastName, userName, password, order, permission);
			client.setUid(aid1);
			client.setFirstName(fistName);
			client.setLastName(lastName);
			client.setUserName(userName);
			client.setPassword(password);	
			client.setOrder(order);			
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

public static void insert(int i, String firstName, String lastName, String userName, String password,int oid, String permission,String tablename) {
	// TODO Auto-generated method stub

	ToolInsert ti = new ToolInsert();
	ti.insertUAC(i, firstName, lastName, userName, password, oid, permission, tablename);
}	
	
	

  
}