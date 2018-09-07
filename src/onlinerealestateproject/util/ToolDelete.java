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
	delete(1,"order1");
  }
 
  

public static void delete(int id, String tablename) throws DataMapperException {
	// TODO Auto-generated method stub
	try {
		Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306"
				+ "/softwarearchitecture?serverTimezone=Australia/Melbourne", "root", "123");					
			String statement = "delete from "+tablename+ " where id=?";
			PreparedStatement dbStatement = db.prepareStatement(statement);
			dbStatement.setInt(1, id);
			dbStatement.executeUpdate();
		
	} catch (SQLException e) {
		
			throw new DataMapperException( e);
	}
	
}

  
}