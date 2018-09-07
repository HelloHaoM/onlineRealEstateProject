package onlinerealestateproject.util;
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
	findClient(1);
  }
  
  public static User findUser(int uid){
	  try {
			String statement ="select * from user where id="+uid;
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
  public static Administrator findAdmin(int aid){
	  try {
		  	String statement ="select * from administrator where id="+aid;
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
  public static Client findClient(int cid){
	  try {
			String statement ="select * from client where id="+cid;
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
				Client client = new Client(id, fistName, 
				lastName, userName, password, oid, permission);
				client.setUid(id);				
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
  
  public static Order findOrder(int id){
	  try {
		  	String statement ="select * from order where oid="+id;
			MySQLConnection mysqlconnection = new MySQLConnection();
			mysqlconnection.getDBConnection();
			mysqlconnection.prepare(statement);
			System.out.println("MySQL JDBC Driver Registered11!");
			System.out.println("MySQL JDBC Driver Registered22!");
			ResultSet rs = mysqlconnection.prepare(statement).executeQuery();
			if(rs.next()) {
				int aid1 = rs.getInt(1);
				System.out.println(aid1);
				String inspStartTime = rs.getString(2);
				System.out.println(inspStartTime);
				String inspEndTime = rs.getString(3);
				System.out.println(inspEndTime);				
				int uid = rs.getInt(4);
				System.out.println(uid);
				int apid = rs.getInt(5);
				System.out.println(apid);
				Order order = new Order(aid1, inspStartTime,inspEndTime, uid,apid);
				order.setUid(aid1);				
				order.setInspStartTime(inspStartTime);
				order.setInspEndTime(inspEndTime);
				order.setUid(uid);
				order.setApid(apid);					
				return order;
			}}
			catch (SQLException e) {
				
				throw new DataMapperException(e);
			}return null;
  }
  
  public static Apartment findApartment(int id){
	  try {
		  	String statement ="select * from apartment where apid="+id;
			MySQLConnection mysqlconnection = new MySQLConnection();
			mysqlconnection.getDBConnection();
			mysqlconnection.prepare(statement);
			System.out.println("MySQL JDBC Driver Registered11!");
			System.out.println("MySQL JDBC Driver Registered22!");
			ResultSet rs = mysqlconnection.prepare(statement).executeQuery();
			if(rs.next()) {
				int apid = rs.getInt(1);
				String startRentTime = rs.getString(2);			
				String endRentTime = rs.getString(3);					
				String availability = rs.getString(4);
				int price = rs.getInt(5);
				int acreage = rs.getInt(6);
				String location = rs.getString(7);
				String apartmentName = rs.getString(8);
				
				Apartment apartment = new Apartment(apid, startRentTime,endRentTime, availability,price,acreage,location, apartmentName);
				apartment.setapid(apid);			
				apartment.setStartRentTime(startRentTime);
				apartment.setEndRentTime(endRentTime);
				apartment.setAvailability(availability);
				apartment.setPrice(price);
				apartment.setAcreage(acreage);
				apartment.setLocation(location);
				apartment.setApartmentName(apartmentName);
				
				return apartment;
			}}
			catch (SQLException e) {
				
				throw new DataMapperException(e);
			}return null;
  }
  
  
}