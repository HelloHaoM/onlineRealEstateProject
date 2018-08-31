package onlinerealestateproject.service;

import java.util.ArrayList;

import onlinerealestateproject.domain.Apartment;

/**
 * @author haomai
 * A apartment service interface
 */
public interface ApartmentService {
	public Apartment getApartment(int Apid);
	public ArrayList<Apartment> getAvailableApartmentList();

}
