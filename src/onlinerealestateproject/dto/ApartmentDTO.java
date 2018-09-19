package onlinerealestateproject.dto;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import onlinerealestateproject.util.UnitofWorkApartment;

/**
 * @author haomai
 * An apartment dto object
 */

public class ApartmentDTO implements Serializable{
	
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
	
	
	public int getApid() {
		return apid;
	}



	public void setApid(int apid) {
		this.apid = apid;
	}



	public String getStartRentTime() {
		return startRentTime;
	}



	public void setStartRentTime(String startRentTime) {
		this.startRentTime = startRentTime;
	}



	public String getEndRentTime() {
		return endRentTime;
	}



	public void setEndRentTime(String endRentTime) {
		this.endRentTime = endRentTime;
	}



	public String getAvailableDate() {
		return availableDate;
	}



	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}



	public String getAvailability() {
		return availability;
	}



	public void setAvailability(String availability) {
		this.availability = availability;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getAcreage() {
		return acreage;
	}



	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getApartmentName() {
		return apartmentName;
	}



	public void setApartmentName(String apartmentName) {
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
	
	public static byte[] object2Byte(ApartmentDTO apartmentDTO) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(apartmentDTO);
			byte[] result = out.toByteArray();
			out.close();
			oos.close();
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ApartmentDTO byte2Object(byte[] apartmentByte) {
		ByteArrayInputStream in = new ByteArrayInputStream(apartmentByte);
		try {
			ObjectInputStream oin = new ObjectInputStream(in);
			ApartmentDTO result = (ApartmentDTO)oin.readObject();
			in.close();
			oin.close();
			return result;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
