package onlinerealestateproject.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import onlinerealestateproject.datasource.ApartmentMapperImpl;
import onlinerealestateproject.datasource.DataMapperException;

/**
 * @author haomai
 * A object of Apartment information
 */
public class Apartment {
	
	public int apid;
	
	// the format should be dd/mm/year
	public  String startRentTime;
	public  String endRentTime;
	public  String availableDate;
	public  ArrayList<String> inspectionTimeList;
	
	public  String availability;
	public  int price;
	public  int acreage;
	public  String location;
	public  String apartmentName;
	
	
	public Apartment(int apid,
			String startRentTime, String endRentTime,
			String availablility, int price, int acreage, String location, String apartmentName) {
		this.apid = apid;
		this.startRentTime = startRentTime;
		this.endRentTime = endRentTime;

		
		this.availability = availablility;
		this.price = price;
		this.location = location;
		this.acreage = acreage;
		this.apartmentName = apartmentName;
	}

	private void load() {
		
	}
	
	public int getapid() {
		if(this.apid == -1)
			load();
		return this.apid;
	}

	public void setapid(int apid) {
		apid = apid;
	}

	public String getStartRentTime() {
		if(this.startRentTime == null)
			load();
		return this.startRentTime;
	}

	public void setStartRentTime(String startRentTime) {
		this.startRentTime = startRentTime;
	}

	public String getEndRentTime() {
		if(this.endRentTime == null)
			load();
		return this.endRentTime;
	}

	public void setEndRentTime(String endRentTime) {
		this.endRentTime = endRentTime;
	}

	public String getAvailableDate() {
		if(this.availableDate == null)
			load();
		return this.availableDate;
	}

	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}

	public ArrayList<String> getInspectionTimeList() {
		if(this.inspectionTimeList == null)
			load();
		return this.inspectionTimeList;
	}

	public void setInspectionTimeList(ArrayList<String> inspectionTimeList) {
		this.inspectionTimeList = new ArrayList<String>(inspectionTimeList);
	}

	public String getAvailability() {
		if(this.availability == null)
			load();
		return this.availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public int getPrice() {
		if(this.price == 0)
			load();
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getApid() {
		return apid;
	}

	public void setApid(int apid) {
		this.apid = apid;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	} 

	public String getLocation() {
		if(this.location == null)
			load();
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAcreage() {
		if(this.acreage == -1)
			load();
		return this.acreage;
	}

	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}
	
	
//	public Apartment find(int id) {
//		
//		ApartmentMapperImpl apartmentMapperImpl = new ApartmentMapperImpl();
//		return apartmentMapperImpl.find(id);
//		
//	}
//	
//	public void insert (Apartment apartment) throws DataMapperException{
//		
//		ApartmentMapperImpl apartmentMapperImpl = new ApartmentMapperImpl();
//		apartmentMapperImpl.insert(apartment);
//	}
//	
//	
//	public void update (Apartment apartment) throws DataMapperException{
//		
//		ApartmentMapperImpl apartmentMapperImpl = new ApartmentMapperImpl();
//		apartmentMapperImpl.delete(apartment);
//	}
//	
//	
//	public void delete (Apartment apartment) throws DataMapperException{
//		
//		ApartmentMapperImpl apartmentMapperImpl = new ApartmentMapperImpl();
//		apartmentMapperImpl.delete(apartment);
//	}
//
//	public List<Apartment> findAllApartments(int id){
//		ApartmentMapperImpl apmi = new ApartmentMapperImpl();
//		return apmi.findAllApartments(id);
//		
//	}

}
