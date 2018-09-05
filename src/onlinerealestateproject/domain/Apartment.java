package onlinerealestateproject.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author haomai
 * A object of Apartment information
 */
public class Apartment {
	
	private int apid;
	
	// the format should be dd/mm/year
	private String startRentTime;
	private String endRentTime;
	private String availableDate;
	private ArrayList<String> inspectionTimeList;
	
	private String availability;
	private int price;
	private int acreage;
	private String location;
	private String apartmentName;
	
	
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
	
	public static Apartment getApartment(int Apid) {
		return null;
	}
	
	public static ArrayList<Apartment> getAvailableApartmentList(){
		return null;
	}
	
	public void addAppartment(Apartment apartment) {
		return;
	}
	
	public void updateApartment(Apartment apartment) {
		return;
	}
	
	public void deleteApartment(Apartment apartment) {
		
	}
	

}
