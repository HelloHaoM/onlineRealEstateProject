package onlinerealestateproject.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Order;

public class AdministratorMapperImpl implements AdministratorMapper {


	public synchronized Administrator find(int aid) throws DataMapperException {
		try {
			Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306"
					+ "/onlineRealEstate?serverTimezone=Australia/Melbourne", "root", "19950110maihao");						
			String sql = "SELECT 'aid', 'firstName', 'lastName', 'userName','password','order','permission' "
					+ " FROM 'administrator' where 'aid'=?";
			PreparedStatement dbStatement = db.prepareStatement(sql);
			dbStatement.setLong(1, aid);
			ResultSet rs = dbStatement.executeQuery();
			
			while(rs.next()) {
				int aid1 = rs.getInt(1);
				String fistName = rs.getString(2);
				String lastName = rs.getString(3);
				String userName = rs.getString(4);
				String password = rs.getString(5);
				int order = rs.getInt(6);
				String permission = rs.getString(7);				
				Administrator administrator = new Administrator(aid1, fistName, 
				lastName, userName, password, order, permission);
				administrator.setUid(aid1);
				administrator.setFirstName(fistName);
				administrator.setLastName(lastName);
				administrator.setUserName(userName);
				administrator.setPassword(password);	
				administrator.setOrder(order);
				return administrator;
			}
			return null;
			
		} catch (SQLException e) {
			
			throw new DataMapperException(e);
		}
	}
	

	@Override
	public void insert(Administrator administrator) throws DataMapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Administrator administrator) throws DataMapperException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Administrator administrator) throws DataMapperException {
		// TODO Auto-generated method stub
		
	}
	

}
