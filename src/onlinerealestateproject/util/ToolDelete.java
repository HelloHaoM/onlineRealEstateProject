package onlinerealestateproject.util;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import onlinerealestateproject.datasource.DataMapperException;
import onlinerealestateproject.domain.Administrator;
/**
 * @author Junjie Huang
 * 
 */
public class ToolDelete {
	
	

  public static void main(String[] argv) {

	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	deleteOrder(1,"inspection_order");
  }
  
	public static boolean deleteOrder(int oid, String tablename) throws DataMapperException{
		try {
			String statement = "delete from "+tablename+ " where oid=?";
			MySQLConnection.getSingleMySQLConnection().establishDBConnection();
			PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(statement);
			dbStatement.setInt(1, oid);
			dbStatement.executeUpdate();
			MySQLConnection.getSingleMySQLConnection().closeConnection();
			return true;
		
		} catch (SQLException e) {
		
			e.printStackTrace();
			//throw new DataMapperException( e);
			return false;
		}
	}
	
	public static boolean deleteApartment(int apid) throws DataMapperException{
		try {
			String statement = "delete from inspection_order where apid=?";
			MySQLConnection.getSingleMySQLConnection().establishDBConnection();
			PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(statement);
			dbStatement.setInt(1, apid);
			dbStatement.executeUpdate();
			MySQLConnection.getSingleMySQLConnection().closeConnection();
			
			String statement_1 = "delete from apartment where apid=?";
			MySQLConnection.getSingleMySQLConnection().establishDBConnection();
			PreparedStatement dbStatement_1 = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(statement_1);
			dbStatement_1.setInt(1, apid);
			dbStatement_1.executeUpdate();
			MySQLConnection.getSingleMySQLConnection().closeConnection();
			return true;
		
		} catch (SQLException e) {
		
			e.printStackTrace();
			//throw new DataMapperException( e);
			return false;
		}
	}
  

	public static boolean delete(int id, String tablename) throws DataMapperException {
		// TODO Auto-generated method stub
		try {
			String statement = "delete from "+tablename+ " where id=?";
			MySQLConnection.getSingleMySQLConnection().establishDBConnection();
			PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(statement);
			dbStatement.setInt(1, id);
			dbStatement.executeUpdate();
			MySQLConnection.getSingleMySQLConnection().closeConnection();
			return true;
		
		} catch (SQLException e) {
		
			e.printStackTrace();
			//throw new DataMapperException( e);
			return false;
		}
	
	}


  
}