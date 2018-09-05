package onlinerealestateproject.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Apartment;
import onlinerealestateproject.*;


public class ApartmentMapperImpl implements ApartmentMapper {
	public static void returnaplist() {
		
		TestFind tf = new TestFind();
		tf.find("SELECT * FROM apartment");
	}
	

//  public static void main(String[] argv) {
//
//	System.out.println("-------- MySQL JDBC Connection Testing ------------");
//	find( "SELECT * FROM apartment");
//  }

  public List<Apartment> find(String statement){
	  List<Apartment> apartments = new ArrayList<>();
		try {
//			String sql = "SELECT * FROM administrator where Aid>"+a;
			MySQLConnection mysqlconnection = new MySQLConnection();
			mysqlconnection.getDBConnection();
			mysqlconnection.prepare(statement);
			ResultSet rs = mysqlconnection.prepare(statement).executeQuery();
			
			while(rs.next()) {
				int apid = rs.getInt(1);
				String startRentTime = rs.getString(2);
				String endRentTime = rs.getString(3);
				String availability = rs.getString(4);
				int price = rs.getInt(5);
				int acreage = rs.getInt(6);				
				String location = rs.getString(7);								
				String apartmentName = rs.getString(7);					
				Apartment apartment = new Apartment(apid, startRentTime, 
				endRentTime, availability, price, acreage, location, apartmentName);
				apartment.setapid(apid);;
				apartment.setStartRentTime(startRentTime);;
				apartment.setEndRentTime(endRentTime);;
				apartment.setAvailability(availability);;
				apartment.setPrice(price);;	
				apartment.setAcreage(acreage);
				apartment.setLocation(location);
				apartment.setApartmentName(apartmentName);
				apartments.add(apartment);
				
			}	
			
		}catch (SQLException e) {
			
			throw new DataMapperException(e);
		}
		System.out.println(apartments.size());
		System.out.println("olala");
		return apartments;
		
		
		
	}




@Override
public void insert(Apartment apartment) throws DataMapperException {
	// TODO Auto-generated method stub
	
}


@Override
public void update(Apartment apartment) throws DataMapperException {
	// TODO Auto-generated method stub
	
}


@Override
public void delete(Apartment apartment) throws DataMapperException {
	// TODO Auto-generated method stub
	
}

}
