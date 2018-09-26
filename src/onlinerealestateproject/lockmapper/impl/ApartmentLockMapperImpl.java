package onlinerealestateproject.lockmapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import onlinerealestateproject.controller.SessionManager;
import onlinerealestateproject.datasource.DataMapperException;
import onlinerealestateproject.domain.Apartment;
import onlinerealestateproject.lock.LockManager;
import onlinerealestateproject.lock.impl.ExclusiveWriteLockManager;
import onlinerealestateproject.lockmapper.ApartmentLockMapper;
import onlinerealestateproject.util.MySQLConnection;
import onlinerealestateproject.util.ToolDelete;
import onlinerealestateproject.util.ToolFind;
import onlinerealestateproject.util.ToolInsert;
import onlinerealestateproject.util.ToolUpdate;

public class ApartmentLockMapperImpl implements ApartmentLockMapper {

	private ApartmentLockMapper aplm;
	private ExclusiveWriteLockManager lm;
	private String sessionId;

	public ApartmentLockMapperImpl(ApartmentLockMapper aplm) {
		this.aplm = aplm;
		this.lm = ExclusiveWriteLockManager.getInstance();
		this.sessionId = SessionManager.getInstance().getHttpSessionId();
	}

	@Override
	public Apartment find(int id) {
		// TODO Auto-generated method stub
		ToolFind tf = new ToolFind();

		return tf.findApartment(id);
	}

	public ArrayList<Apartment> findAllApartments() {
		ArrayList<Apartment> apartments = new ArrayList<>();
		try {

			String statement = "select * from apartment";
			MySQLConnection.getSingleMySQLConnection().establishDBConnection();
			ResultSet rs = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(statement)
					.executeQuery();
			while (rs.next()) {
				int apid = rs.getInt(1);
				String startRentTime = rs.getString(2);
				String endRentTime = rs.getString(3);
				String availability = rs.getString(4);
				int price = rs.getInt(5);
				int acreage = rs.getInt(6);
				String location = rs.getString(7);
				String apartmentName = rs.getString(8);
				Apartment apartment = new Apartment(apid, startRentTime, endRentTime, availability, price, acreage,
						location, apartmentName);
				apartment.setapid(apid);
				;
				apartment.setStartRentTime(startRentTime);
				;
				apartment.setEndRentTime(endRentTime);
				;
				apartment.setAvailability(availability);
				;
				apartment.setPrice(price);
				;
				apartment.setAcreage(acreage);
				apartment.setLocation(location);
				apartment.setApartmentName(apartmentName);
				apartments.add(apartment);

			}
			MySQLConnection.getSingleMySQLConnection().closeConnection();

		} catch (SQLException e) {

			throw new DataMapperException(e);
		}
		System.out.println(apartments.size());
		return apartments;

	}

	@Override
	public boolean insert(Apartment apartment) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolInsert ti = new ToolInsert();
		if(ti.insertAp(apartment.apid, apartment.startRentTime, apartment.endRentTime, apartment.availability,
				apartment.price, apartment.acreage, apartment.location, apartment.apartmentName)){
				return true;
		}
		return false;
	}

	@Override
	public boolean update(Apartment apartment) throws DataMapperException{
		// TODO Auto-generated method stub
		if (lm.hasLock(apartment.apid, sessionId)) {
			ToolUpdate tu = new ToolUpdate();
			if(tu.updateAp(apartment.apid, apartment.startRentTime, apartment.endRentTime, apartment.availability,
				apartment.price, apartment.acreage, apartment.location, apartment.apartmentName))
				return true;
			return false;
		} else {
			System.out.println("doesn't have lock");
		}
		return false;
	}
	

	@Override
	public boolean delete(Apartment apartment)throws DataMapperException {
		// TODO Auto-generated method stub
		if (lm.hasLock(apartment.apid, sessionId)) {
			ToolDelete td = new ToolDelete();
			if(td.delete(apartment.getapid(), "apartment"))
				return true;
			return false;
		} else {
			System.out.println("doesn't have lock");
		}
		return false;
	}

	@Override
	public boolean delete(int apid) throws DataMapperException {
		// TODO Auto-generated method stub
		if (lm.hasLock(apid, sessionId)) {
			ToolDelete td = new ToolDelete();
			if(td.deleteApartment(apid))
				return true;
			return false;
		}else {
			System.out.println("doesn't have lock");
		}
		return false;
	}

}
