package onlinerealestateproject.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import onlinerealestateproject.datasource.DataMapperException;
import onlinerealestateproject.datasource.imp.ApartmentMapperImpl;
import onlinerealestateproject.util.IdentityMap;
import onlinerealestateproject.util.UnitofWorkApartment;

/**
 * @author haomai
 * A object of Apartment information
 */
public class Apartment {
	//Apartment apartment = new Apartment(0, null, null, null, 0, 0, null, null);
	IdentityMap<Apartment> map = IdentityMap.getInstance(this);
	
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
		UnitofWorkApartment.getCurrent().registerNew(this);
	}

	private void load() {
		ApartmentMapperImpl apartmentMapperImpl = new ApartmentMapperImpl();
		Apartment record = apartmentMapperImpl.find(this.getApid()); 
		if (this.apid == -1) {
			this.apid = record.getapid(); }
			if (this.startRentTime == null) {
			this.startRentTime = record.getStartRentTime();
			UnitofWorkApartment.getCurrent().registerDirty(this);
			}
			if (this.endRentTime == null) {
			this.endRentTime = record.getEndRentTime();
			UnitofWorkApartment.getCurrent().registerDirty(this);
			}
			if (this.availability == null) {
				this.availability = record.getAvailability();
				UnitofWorkApartment.getCurrent().registerDirty(this);
				}
			if (this.price == -1) {
				this.price = record.getPrice();
				UnitofWorkApartment.getCurrent().registerDirty(this);
				}
			if (this.acreage == -1) {
				this.acreage = record.getAcreage();
				UnitofWorkApartment.getCurrent().registerDirty(this);
				}
			if (this.location == null) {
				this.location = record.getLocation();
				UnitofWorkApartment.getCurrent().registerDirty(this);
				}
			if (this.apartmentName == null) {
				this.apartmentName = record.getApartmentName();
				UnitofWorkApartment.getCurrent().registerDirty(this);
				}
	}
	
	public int getapid() {
		if(this.apid == -1)
			load();
		return this.apid;
	}

	public void setapid(int apid) {
		apid = apid;
		UnitofWorkApartment.getCurrent().registerDirty(this);
	}

	public String getStartRentTime() {
		if(this.startRentTime == null)
			load();
		return this.startRentTime;
	}

	public void setStartRentTime(String startRentTime) {
		this.startRentTime = startRentTime;
		UnitofWorkApartment.getCurrent().registerDirty(this);
	}

	public String getEndRentTime() {
		if(this.endRentTime == null)
			load();
		return this.endRentTime;
	}

	public void setEndRentTime(String endRentTime) {
		this.endRentTime = endRentTime;
		UnitofWorkApartment.getCurrent().registerDirty(this);
	}

	public String getAvailableDate() {
		if(this.availableDate == null)
			load();
		return this.availableDate;
	}

	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
		UnitofWorkApartment.getCurrent().registerDirty(this);
	}

	public ArrayList<String> getInspectionTimeList() {
		if(this.inspectionTimeList == null)
			load();
		return this.inspectionTimeList;
	}

	public void setInspectionTimeList(ArrayList<String> inspectionTimeList) {
		this.inspectionTimeList = new ArrayList<String>(inspectionTimeList);
		UnitofWorkApartment.getCurrent().registerDirty(this);
	}

	public String getAvailability() {
		if(this.availability == null)
			load();
		return this.availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
		UnitofWorkApartment.getCurrent().registerDirty(this);
	}

	public int getPrice() {
		if(this.price == 0)
			load();
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
		UnitofWorkApartment.getCurrent().registerDirty(this);
	}

	public int getApid() {
		return apid;
	}

	public void setApid(int apid) {
		this.apid = apid;
		UnitofWorkApartment.getCurrent().registerDirty(this);
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
		UnitofWorkApartment.getCurrent().registerDirty(this);
	} 

	public String getLocation() {
		if(this.location == null)
			load();
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
		UnitofWorkApartment.getCurrent().registerDirty(this);
	}

	public int getAcreage() {
		if(this.acreage == -1)
			load();
		
		return this.acreage;
	}

	public void setAcreage(int acreage) {
		this.acreage = acreage;
		UnitofWorkApartment.getCurrent().registerDirty(this);
	}
	
	
	public Apartment find(int id) {
		
		ApartmentMapperImpl apartmentMapperImpl = new ApartmentMapperImpl();
		return apartmentMapperImpl.find(id);
		
	}
	
	public void insert (Apartment apartment) throws DataMapperException{
		UnitofWorkApartment.newCurrent();
		if(map.get(apartment.getapid())==null){
//		ApartmentMapperImpl apartmentMapperImpl = new ApartmentMapperImpl();
//		apartmentMapperImpl.insert(apartment);
			map.put(apartment.getapid(), apartment);
			UnitofWorkApartment.getCurrent().registerNew(map.get(apartment.getapid()));
			UnitofWorkApartment.getCurrent().commit();
		}
	}
	
	
	public void update (Apartment apartment) throws DataMapperException{
		UnitofWorkApartment.newCurrent();
		if(map.get(apartment.getapid())!=null){
//		ApartmentMapperImpl apartmentMapperImpl = new ApartmentMapperImpl();
//		apartmentMapperImpl.update(apartment);
			map.put(apartment.getapid(), apartment);
			UnitofWorkApartment.getCurrent().registerDirty(map.get(apartment.getapid()));
			UnitofWorkApartment.getCurrent().commit();
		}
		
	}
	
	
	public void delete (Apartment apartment) throws DataMapperException{
		UnitofWorkApartment.newCurrent();
		if(map.get(apartment.getapid())!=null){
//		ApartmentMapperImpl apartmentMapperImpl = new ApartmentMapperImpl();
//		apartmentMapperImpl.delete(apartment);
			map.put(apartment.getApid(), null);
			UnitofWorkApartment.getCurrent().registerDeleted(map.get(apartment.getapid()));
			UnitofWorkApartment.getCurrent().commit();
		}
	}


	public ArrayList<Apartment> findAllApartments(){

		ApartmentMapperImpl apmi = new ApartmentMapperImpl();
		return apmi.findAllApartments();
		
	}

}
