package onlinerealestateproject.domain;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.InputStream;
import java.io.OutputStream;

import onlinerealestateproject.util.UnitofWorkApartment;

public class ApartmentDTO {
	
	public int apid;
	
	public  String startRentTime;
	public  String endRentTime;
	public  String availableDate;
	
	public  String availability;
	public  int price;
	public  int acreage;
	public  String location;
	public  String apartmentName;
	
	public ApartmentDTO(int apid,
			String startRentTime, String endRentTime,
			String availablility, int price, int acreage, String location, String apartmentName) {
		
		this.apid = apid;
		this.startRentTime = startRentTime;
		this.endRentTime = endRentTime;

		
		this.availability = availablility;
		this.price = price;
		this.acreage = acreage;
		this.location = location;
		this.apartmentName = apartmentName;
	}
	
	public static void toXML(ApartmentDTO apartmentDTO, OutputStream outputStream) {
		XMLEncoder encoder = new XMLEncoder(outputStream);
		encoder.writeObject(apartmentDTO);
		encoder.close();
	}
	
	public static ApartmentDTO fromDTO(InputStream inputStream) {
		XMLDecoder decoder = new XMLDecoder(inputStream);
		ApartmentDTO result = (ApartmentDTO) decoder.readObject();
		decoder.close();
		return result;
	}

}
