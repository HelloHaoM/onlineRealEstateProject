package Util;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import onlinerealestateproject.datasource.DataMapperException;
import onlinerealestateproject.datasource.MySQLConnection;
import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Apartment;
import onlinerealestateproject.domain.Client;
import onlinerealestateproject.domain.Order;
import onlinerealestateproject.domain.User;
/**
 * @author Junjie Huang
 * 
 */
public class ToolFind {

  public static void main(String[] argv) {

	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	findClient("SELECT * FROM client where userName= 'steve'");
  }
  
  public static User findUser(String statement){
	  try {
			String sql =statement;
			MySQLConnection mysqlconnection = new MySQLConnection();
			mysqlconnection.getDBConnection();
			mysqlconnection.prepare(statement);
			System.out.println("MySQL JDBC Driver Registered11!");
			System.out.println("MySQL JDBC Driver Registered22!");
			ResultSet rs = mysqlconnection.prepare(statement).executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
				System.out.println(id);
				String fistName = rs.getString(2);
				System.out.println(fistName);
				String lastName = rs.getString(3);
				System.out.println(lastName);
				String userName = rs.getString(4);
				System.out.println(userName);
				String password = rs.getString(5);
				System.out.println(password);
				int oid = rs.getInt(6);
				System.out.println(oid);
				String permission = rs.getString(7);	
//				System.out.println(permission);
				System.out.println(permission);
				User user = new User(id, fistName, 
				lastName, userName, password, oid, permission);
				user.setUid(id);				
				user.setFirstName(fistName);
				user.setLastName(lastName);
				user.setUserName(userName);
				user.setPassword(password);	
				user.setOrder(oid);
				user.setPermission(permission);
				return user;
			}}
			catch (SQLException e) {
				
				throw new DataMapperException(e);
			}return null;
  }
  public static Administrator findAdmin(String statement){
	  try {
			String sql =statement;
			MySQLConnection mysqlconnection = new MySQLConnection();
			mysqlconnection.getDBConnection();
			mysqlconnection.prepare(statement);
			System.out.println("MySQL JDBC Driver Registered11!");
			System.out.println("MySQL JDBC Driver Registered22!");
			ResultSet rs = mysqlconnection.prepare(statement).executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
				System.out.println(id);
				String fistName = rs.getString(2);
				System.out.println(fistName);
				String lastName = rs.getString(3);
				System.out.println(lastName);
				String userName = rs.getString(4);
				System.out.println(userName);
				String password = rs.getString(5);
				System.out.println(password);
				int oid = rs.getInt(6);
				System.out.println(oid);
				String permission = rs.getString(7);	
//				System.out.println(permission);
				System.out.println(permission);
				Administrator administrator = new Administrator(id, fistName, 
				lastName, userName, password, oid, permission);
				administrator.setUid(id);				
				administrator.setFirstName(fistName);
				administrator.setLastName(lastName);
				administrator.setUserName(userName);
				administrator.setPassword(password);	
				administrator.setOrder(oid);
				administrator.setPermission(permission);
				return administrator;
			}}
			catch (SQLException e) {
				
				throw new DataMapperException(e);
			}return null;
  }
  public static Client findClient(String statement){
	  try {
			String sql =statement;
			MySQLConnection mysqlconnection = new MySQLConnection();
			mysqlconnection.getDBConnection();
			mysqlconnection.prepare(statement);
			System.out.println("MySQL JDBC Driver Registered11!");
			System.out.println("MySQL JDBC Driver Registered22!");
			ResultSet rs = mysqlconnection.prepare(statement).executeQuery();
			if(rs.next()) {
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
				int oid = rs.getInt(6);
				System.out.println(oid);
				String permission = rs.getString(7);	
//				System.out.println(permission);
				System.out.println(permission);
				Client client = new Client(aid1, fistName, 
				lastName, userName, password, oid, permission);
				client.setUid(aid1);				
				client.setFirstName(fistName);
				client.setLastName(lastName);
				client.setUserName(userName);
				client.setPassword(password);	
				client.setOrder(oid);
				client.setPermission(permission);
				return client;
			}}
			catch (SQLException e) {
				
				throw new DataMapperException(e);
			}return null;
  }
  
}