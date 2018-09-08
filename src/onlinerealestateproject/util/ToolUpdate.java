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
public class ToolUpdate {

//  public static void main(String[] argv) {
//
//	System.out.println("-------- MySQL JDBC Connection Testing ------------");
////	updateUAC(1,"ssssssss","a","s","123",1,"ok","client");
//	updateAp(1,"09/2018","10/2018","no",100,200,"olala","olala");
//  } 
 
public static boolean updateUAC(int id, String firstName, String lastName, String userName, String password,int oid,String permission
	 ,String tablename){
	try {
		switch(tablename) {
		case "administrator":
			Administrator administrator = new Administrator(id, firstName, lastName,userName, password,oid,permission);
			String statement = "update administrator set id=?, firstName=?, lastName=?, userName=?,password=?,oid=?,permission = ? where id="+id;
			PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(statement);
			System.out.println("MySQL JDBC Driver Registered11!");
			System.out.println("MySQL JDBC Driver Registered22!");
			dbStatement.setInt(1, administrator.getUid());
			dbStatement.setString(2, administrator.getFirstName());
			dbStatement.setString(3, administrator.getLastName());
			dbStatement.setString(4, administrator.getUserName());
			dbStatement.setString(5, administrator.getPassword());
			dbStatement.setInt(6, administrator.getOrder());	
			dbStatement.setString(7, administrator.getPermission());
			dbStatement.executeUpdate();
			break;
		case "user":
			User user = new User(id, firstName, lastName,userName, password,oid,permission);
			String statement1 = "update users set id=?, firstName=?, lastName=?, userName=?,password=?,oid=?,permission = ? where id="+id;
			PreparedStatement dbStatement1 = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(statement1);
			System.out.println("MySQL JDBC Driver Registered11!");
			System.out.println("MySQL JDBC Driver Registered22!");
			dbStatement1.setInt(1, user.getUid());
			dbStatement1.setString(2, user.getFirstName());
			dbStatement1.setString(3, user.getLastName());
			dbStatement1.setString(4, user.getUserName());
			dbStatement1.setString(5, user.getPassword());
			dbStatement1.setInt(6, user.getOrder());	
			dbStatement1.setString(7, user.getPermission());	
			dbStatement1.executeUpdate();
			break;
		
		case "client":
			Client client = new Client(id, firstName, lastName,userName, password,oid,permission);
			String statement2 = "update client set id=?, firstName=?, lastName=?, userName=?,password=?,oid=?,permission = ? where id="+id;
			PreparedStatement dbStatement2 = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(statement2);
			System.out.println("MySQL JDBC Driver Registered11!");
			System.out.println("MySQL JDBC Driver Registered22!");
			dbStatement2.setInt(1, client.getUid());
			dbStatement2.setString(2, client.getFirstName());
			dbStatement2.setString(3, client.getLastName());
			dbStatement2.setString(4, client.getUserName());
			dbStatement2.setString(5, client.getPassword());
			dbStatement2.setInt(6, client.getOrder());	
			dbStatement2.setString(7, client.getPermission());	
			dbStatement2.executeUpdate();
			
			
		}
	}
	
	 catch (SQLException e) {
		
		//throw new DataMapperException(e);
		 return false;
	}
	return true;

}
public static boolean updateAp(int apid, String StartRentTime, String EndRentTime, String  Availability, int price,int acreage,String location,String apartmentName){
		try {
			
				Apartment apartment = new Apartment(apid, StartRentTime, EndRentTime,Availability, price,acreage,location,apartmentName);
				String statement = "update apartment set apid=?, StartRentTime=?, EndRentTime=?, Availability=?,price=?,acreage=?,location = ?, apartmentName =? where apid="+apid;
				PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(statement);
				System.out.println("MySQL JDBC Driver Registered11!");
				System.out.println("MySQL JDBC Driver Registered22!");
				dbStatement.setInt(1, apartment.getapid());
				dbStatement.setString(2, apartment.getStartRentTime());
				dbStatement.setString(3, apartment.getEndRentTime());
				dbStatement.setString(4, apartment.getAvailability());
				dbStatement.setInt(5, apartment.getPrice());
				dbStatement.setInt(6, apartment.getAcreage());	
				dbStatement.setString(7, apartment.getLocation());
				dbStatement.setString(8, apartment.getApartmentName());
				dbStatement.executeUpdate();
			}catch (SQLException e) {
	
				e.printStackTrace();
				//throw new DataMapperException(e);
				return false;
			}
		return true;
}

public static boolean updateOrder(int oid, String inspStartTime, String inspEndTime, int id, int apid){
		try {
			
				Order order = new Order(oid, inspStartTime, inspEndTime,id, apid);
				String statement = "update order set oid=?, inspStartTime=?, inspEndTime=?, id=?,apid=? where oid="+oid;
				PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(statement);
				System.out.println("MySQL JDBC Driver Registered11!");
				System.out.println("MySQL JDBC Driver Registered22!");
				dbStatement.setInt(1, order.getUid());
				dbStatement.setString(2, order.getInspStartTime());
				dbStatement.setString(3, order.getInspEndTime());
				dbStatement.setInt(4, order.getUid());
				dbStatement.setInt(5, order.getApid());
				dbStatement.executeUpdate();
			}catch (SQLException e) {
	
				e.printStackTrace();
				//throw new DataMapperException(e);
				return false;
			}
		return true;
}

public static boolean updateOrderInspectionTime(int oid, String inspectionTime){
	try {
		
			String statement = "update inspection_order set inspStartTime=?, inspEndTime=? where oid="+oid;
			PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(statement);
			System.out.println("MySQL JDBC Driver Registered11!");
			System.out.println("MySQL JDBC Driver Registered22!");
			dbStatement.setString(1, inspectionTime);
			dbStatement.setString(2, inspectionTime);
			dbStatement.executeUpdate();
		}catch (SQLException e) {

			e.printStackTrace();
			//throw new DataMapperException(e);
			return false;
		}
	return true;
}

}