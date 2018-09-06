package onlinerealestateproject.datasource;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Apartment;
import onlinerealestateproject.domain.Client;
import onlinerealestateproject.domain.Order;
import onlinerealestateproject.domain.User;
/**
 * @author Junjie Huang
 * 
 */
public class ToolInsert {

//  public static void main(String[] argv) {
//
//	System.out.println("-------- MySQL JDBC Connection Testing ------------");
//	insertUAC(999,"steve","aoki","steve","123",3,"no","user");
//	insertAp(999,"08/09/2018","09/09/2018","yes",100,100,"parkvile","empirestatebuilding");
//	insertOrder(0, "08/09/2018","09/09/2018", 1, 1);
//  }
  public static void insertOrder(int oid, String inspStartTime ,String inspEndTime , int id,int apid) {
		// TODO Auto-generated method stub
		try {
			
				MySQLConnection mysqlconnection = new MySQLConnection();		
				Order order = new Order(oid, inspStartTime , inspEndTime ,  id, apid);			
				String statement = "insert into Order1 ( inspStartTime , inspEndTime ,  id, apid)  values (  ?,?,?,?)";
				mysqlconnection.getDBConnection();
				System.out.println("hello");
				PreparedStatement dbStatement = mysqlconnection.prepare(statement);
				System.out.println(dbStatement);	
				dbStatement.setString(1, inspStartTime);
				dbStatement.setString(2,inspEndTime);
				dbStatement.setInt(3,id);
				dbStatement.setInt(4, apid);	

				dbStatement.executeUpdate();
		
		}catch (SQLException e) {
		 
			throw new DataMapperException( e);
	}
	}
  public static void insertAp(int apid, String StartRentTime,String EndRentTime, String Availability, int price,int acreage,String location, String apartmentName) {
		// TODO Auto-generated method stub
		try {
			
				MySQLConnection mysqlconnection = new MySQLConnection();		
				Apartment apartment = new Apartment(apid, StartRentTime, EndRentTime,  Availability,  price, acreage, location, apartmentName);			
				String statement = "insert into apartment ( StartRentTime, EndRentTime,  Availability,  price, acreage, location, apartmentName)  values ( ?, ?, ?, ?,?,?,?)";
				mysqlconnection.getDBConnection();
				System.out.println("hello");
				PreparedStatement dbStatement = mysqlconnection.prepare(statement);
				System.out.println(dbStatement);	
				dbStatement.setString(1, StartRentTime);
				dbStatement.setString(2,EndRentTime);
				dbStatement.setString(3, Availability);
				dbStatement.setInt(4, price);	
				dbStatement.setInt(5, acreage);	
				dbStatement.setString(6, location);
				dbStatement.setString(7, apartmentName);
				dbStatement.executeUpdate();
		
		}catch (SQLException e) {
		 
			throw new DataMapperException( e);
	}
	}

  
  public static void insertUAC(int id, String firstName, String lastName, String userName, String password,int oid,String permission, String tablename) {
	  // TODO Auto-generated method stub
	  try {
		  switch(tablename) {
		  case "administrator":
			  MySQLConnection mysqlconnection = new MySQLConnection();		
			  Administrator administrator = new Administrator(id, firstName, lastName, userName, password, oid, permission);			
			  String statement = "insert into administrator ( firstName, lastName, userName, password,oid,permission)  values ( ?, ?, ?, ?,?,?)";
				mysqlconnection.getDBConnection();
				System.out.println("hello");
				PreparedStatement dbStatement = mysqlconnection.prepare(statement);
				System.out.println(dbStatement);	
				dbStatement.setString(1, firstName);
				dbStatement.setString(2, lastName);
				dbStatement.setString(3, userName);
				dbStatement.setString(4, password);		
				dbStatement.setInt(5, oid);	
				dbStatement.setString(6, permission);	
			
				break;	
			
		case "user":
				MySQLConnection mysqlconnection1 = new MySQLConnection();		
				User user = new User(id, firstName, lastName, userName, password, oid, permission);			
				String statement1 = "insert into user ( firstName, lastName, userName, password,oid,permission)  values ( ?, ?, ?, ?,?,?)";
				mysqlconnection1.getDBConnection();
				System.out.println("hello");
				PreparedStatement dbStatement1 = mysqlconnection1.prepare(statement1);
				System.out.println(dbStatement1);	
				dbStatement1.setString(1, firstName);
				dbStatement1.setString(2, lastName);
				dbStatement1.setString(3, userName);
				dbStatement1.setString(4, password);	
				dbStatement1.setInt(5, oid);	
				dbStatement1.setString(6, permission);		
				dbStatement1.executeUpdate();
				break;	
			case "client":
				MySQLConnection mysqlconnection2 = new MySQLConnection();		
				Client client = new Client(id, firstName, lastName, userName, password, oid, permission);			
				String statement2 = "insert into client ( firstName, lastName, userName, password,oid,permission)  values ( ?, ?, ?, ?,?,?)";
				mysqlconnection2.getDBConnection();		
				System.out.println("hello");
				PreparedStatement dbStatement2 = mysqlconnection2.prepare(statement2);
				System.out.println(dbStatement2);	
				dbStatement2.setString(1, firstName);	
				dbStatement2.setString(2, lastName);
				dbStatement2.setString(3, userName);
				dbStatement2.setString(4, password);		
				dbStatement2.setInt(5, oid);		
				dbStatement2.setString(6, permission);	
				dbStatement2.executeUpdate();
				break;
			
		
		}
} catch (SQLException e) {
	 
		throw new DataMapperException( e);
}
}	
	

  
}