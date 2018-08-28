package onlinerealestateproject.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author haomai
 * A object of Apartment information
 */
public class Apartment {
	
	private int apid;
	
	// the format should be yyyy-mm-dd
	private String startRentTime;
	private String endRentTime;
	private String availableDate;
	private ArrayList<String> inspectionTimeList;
	
	private int availability;
	private String price;
	private String location;
	private int acreage;
	
	public Apartment(int apid,
			String startRentTime, String endRentTime, String availableDate,
			ArrayList<String> inspectionTimeList,
			int availablility, String price, String location, int acreage) {
		this.apid = apid;
		this.startRentTime = startRentTime;
		this.endRentTime = endRentTime;
		this.availableDate = availableDate;
		this.inspectionTimeList = new ArrayList<String>(inspectionTimeList);
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

	public int getAvailability() {
		if(this.availability == -1)
			load();
		return this.availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public String getPrice() {
		if(this.price == null)
			load();
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
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
