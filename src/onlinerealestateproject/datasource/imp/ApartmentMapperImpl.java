package onlinerealestateproject.datasource.imp;

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
import onlinerealestateproject.util.IdentityMap;
import onlinerealestateproject.util.ToolDelete;
import onlinerealestateproject.util.ToolFind;
import onlinerealestateproject.util.ToolInsert;
import onlinerealestateproject.util.ToolUpdate;
import onlinerealestateproject.*;
import onlinerealestateproject.datasource.ApartmentMapper;
import onlinerealestateproject.datasource.DataMapperException;
import onlinerealestateproject.datasource.MySQLConnection;

/**
 * @author Junjie Huang
 * 
 */
public class ApartmentMapperImpl implements ApartmentMapper {
	Apartment apartment = new Apartment(0, null, null, null, 0, 0, null, null);
	IdentityMap<Apartment> map = IdentityMap.getInstance(apartment);
	

//  public static void main(String[] argv) {
//
//	System.out.println("-------- MySQL JDBC Connection Testing ------------");
//	find( "SELECT * FROM apartment");
//  }
 
  public ArrayList<Apartment> findAllApartments(){
	  ArrayList<Apartment> apartments = new ArrayList<>();
		try {

			String statement = "select * from apartment";
//			MySQLConnection mysqlconnection = new MySQLConnection();
//			mysqlconnection.getDBConnection();
//			mysqlconnection.prepare(statement);
			ResultSet rs = MySQLConnection.prepare(statement).executeQuery();

			 
			while(rs.next()) {
				int apid = rs.getInt(1);
				String startRentTime = rs.getString(2);
				String endRentTime = rs.getString(3);
				String availability = rs.getString(4);
				int price = rs.getInt(5);
				int acreage = rs.getInt(6);				
				String location = rs.getString(7);								
				String apartmentName = rs.getString(8);					
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

public boolean insert(Apartment apartment) throws DataMapperException {
	// TODO Auto-generated method stub
	ToolInsert ti = new ToolInsert();
	if(ti.insertAp(apartment.apid, apartment.startRentTime, apartment.endRentTime, apartment.availability,
			apartment.price, apartment.acreage, apartment.location, apartment.apartmentName))
	{
		map.put(apartment.getapid(),apartment);
		return true;
		}
	return false;
	
}


@Override


public boolean update(Apartment apartment) throws DataMapperException {
	// TODO Auto-generated method stub
	ToolUpdate tu = new ToolUpdate();
	if(map.get(apartment.getapid())!=null){
		map.put(apartment.getapid(), apartment);
	
		if(tu.updateAp(apartment.apid, apartment.startRentTime, apartment.endRentTime, apartment.availability,
				apartment.price, apartment.acreage, apartment.location, apartment.apartmentName))
			return true;
		return false;
	}
	return false;
}


@Override

public boolean delete(Apartment apartment) throws DataMapperException {
	// TODO Auto-generated method stub
	ToolDelete td = new ToolDelete();
	if(map.get(apartment.getapid())!=null){
		map.put(apartment.getapid(), null);
		if(td.delete(apartment.getapid(), "apartment"))
		return true;
	return false;
}

return false;
}




@Override

public Apartment find(int id) {
	// TODO Auto-generated method stub
	ToolFind tf = new ToolFind();
	map.put(id, tf.findApartment(id));
	return map.get(id);
	


}








}
