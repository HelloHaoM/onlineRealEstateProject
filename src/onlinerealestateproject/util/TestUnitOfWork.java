package onlinerealestateproject.util;

import onlinerealestateproject.datasource.ApartmentMapper;
import onlinerealestateproject.datasource.imp.ApartmentMapperImpl;
import onlinerealestateproject.domain.Apartment;

public class TestUnitOfWork {
	public static void main(String args[]) {
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		int apid = 0;
		String startRentTime = "test1";
		String endRentTime = "test1";
		String availability = "test1";
		int price = 100;
		int acreage = 200;
		String location = "a";
		String apartmentName = "Apa";
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
		System.out.println(apartment.apartmentName);
	}

}
