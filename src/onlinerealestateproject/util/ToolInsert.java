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
public class ToolInsert {

//  public static void main(String[] argv) {
//
//	System.out.println("-------- MySQL JDBC Connection Testing ------------");
//	insertUAC(999,"okok","okok","steve","123",3,"no","client");
//	insertAp(999,"08/09/2018","09/09/2018","yes",100,100,"parkvile","empirestatebuilding");
//	insertOrder(0, "08/09/2018","09/09/2018", 1, 1);
//  }
  
  public static boolean insertOrder(int oid, String inspStartTime ,String inspEndTime , int id,int apid) {
		// TODO Auto-generated method stub
		try {
			
//				MySQLConnection mysqlconnection = new MySQLConnection();		
				Order order = new Order(oid, inspStartTime , inspEndTime ,  id, apid);			
				String statement = "insert into inspection_order ( inspStartTime , inspEndTime ,  id, apid)  values (  ?,?,?,?)";
//				mysqlconnection.getDBConnection();
				System.out.println("hello");
				PreparedStatement dbStatement = MySQLConnection.prepare(statement);
				System.out.println(dbStatement);	
				dbStatement.setString(1, inspStartTime);
				dbStatement.setString(2,inspEndTime);
				dbStatement.setInt(3,id);
				dbStatement.setInt(4, apid);	
				dbStatement.executeUpdate();
				
				return true;
		
		}catch (SQLException e) {
		 
			e.printStackTrace();
			//throw new DataMapperException( e);
			return false;
	}
	}
  public static boolean insertAp(int apid, String StartRentTime,String EndRentTime, String Availability, int price,int acreage,String location, String apartmentName) {
		// TODO Auto-generated method stub
		try {
			
//				MySQLConnection mysqlconnection = new MySQLConnection();		
				Apartment apartment = new Apartment(apid, StartRentTime, EndRentTime,  Availability,  price, acreage, location, apartmentName);			
				String statement = "insert into apartment ( StartRentTime, EndRentTime,  Availability,  price, acreage, location, apartmentName)  values ( ?, ?, ?, ?,?,?,?)";
//				mysqlconnection.getDBConnection();
				System.out.println("hello");
				PreparedStatement dbStatement = MySQLConnection.prepare(statement);
				System.out.println(dbStatement);	
				dbStatement.setString(1, StartRentTime);
				dbStatement.setString(2,EndRentTime);
				dbStatement.setString(3, Availability);
				dbStatement.setInt(4, price);	
				dbStatement.setInt(5, acreage);	
				dbStatement.setString(6, location);
				dbStatement.setString(7, apartmentName);
				dbStatement.executeUpdate();
				
				return true;
		
		}catch (SQLException e) {
		 
			e.printStackTrace();
			//throw new DataMapperException( e);
			return false;
	}
	}

  
  public static boolean insertUAC(int id, String firstName, String lastName, String userName, String password,int oid,String permission, String tablename) {
	  // TODO Auto-generated method stub
	  try {
		  switch(tablename) {
		  case "administrator":
			  String statement1 = "insert into user ( firstName, lastName, userName, password,oid,permission)  values ( ?, ?, ?, ?,?,?)";
			  PreparedStatement dbStatement1 = MySQLConnection.prepare(statement1);
			  System.out.println(dbStatement1);	
			  dbStatement1.setString(1, firstName);
			  dbStatement1.setString(2, lastName);
			  dbStatement1.setString(3, userName);
			  dbStatement1.setString(4, password);	
			  dbStatement1.setInt(5, oid);	
			  dbStatement1.setString(6, permission);		
			  dbStatement1.executeUpdate();
			  		
			  Administrator administrator = new Administrator(id, firstName, lastName, userName, password, oid, permission);			
			  String statement = "insert into administrator ( firstName, lastName, userName, password,oid,permission)  values ( ?, ?, ?, ?,?,?)";
			  PreparedStatement dbStatement = MySQLConnection.prepare(statement);
			  System.out.println(dbStatement);	
			  dbStatement.setString(1, firstName);
			  dbStatement.setString(2, lastName);
			  dbStatement.setString(3, userName);
			  dbStatement.setString(4, password);		
			  dbStatement.setInt(5, oid);	
			  dbStatement.setString(6, permission);	
			  dbStatement.executeUpdate();  
			  break;
			

				
			case "client":
				String statement3 = "insert into user ( firstName, lastName, userName, password,oid,permission)  values ( ?, ?, ?, ?,?,?)";
				PreparedStatement dbStatement3 = MySQLConnection.prepare(statement3);
				System.out.println(dbStatement3);	
				dbStatement3.setString(1, firstName);
				dbStatement3.setString(2, lastName);
				dbStatement3.setString(3, userName);
				dbStatement3.setString(4, password);	
				dbStatement3.setInt(5, oid);	
				dbStatement3.setString(6, permission);		
				dbStatement3.executeUpdate();
					
				Client client = new Client(id, firstName, lastName, userName, password, oid, permission);			
				String statement2 = "insert into client ( firstName, lastName, userName, password,oid,permission)  values ( ?, ?, ?, ?,?,?)";	
				PreparedStatement dbStatement2 = MySQLConnection.prepare(statement2);
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
	 
		//throw new DataMapperException( e);
		  e.printStackTrace();
		  return false;
	  }
	return true;
}	
	

  
}