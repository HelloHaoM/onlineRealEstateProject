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
public class ToolDelete {
	
	

  public static void main(String[] argv) {

	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	deleteOrder(1,"inspection_order");
  }
  
	public static boolean deleteOrder(int oid, String tablename) throws DataMapperException{
		try {
			String statement = "delete from "+tablename+ " where oid=?";
			PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(statement);
			dbStatement.setInt(1, oid);
			dbStatement.executeUpdate();
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
			PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(statement);
			dbStatement.setInt(1, id);
			dbStatement.executeUpdate();
			return true;
		
	} catch (SQLException e) {
		
		e.printStackTrace();
			//throw new DataMapperException( e);
		return false;
	}
	
}


  
}