package onlinerealestateproject.util;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import onlinerealestateproject.domain.Administrator;

public class Connection {



public void connection(){
	
		
		try {
			java.sql.Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306"
					+ "/softwarearchitecture?serverTimezone=Australia/Melbourne", "root", "123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}						
	}
  
}