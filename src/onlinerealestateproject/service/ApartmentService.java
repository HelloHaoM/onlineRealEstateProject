package onlinerealestateproject.service;

import java.util.ArrayList;

import onlinerealestateproject.domain.Apartment;

/**
 * @author haomai
 * A apartment service interface
 */
public interface ApartmentService {
	// Get a apartment by an apid
	public Apartment getApartment(int apid);
	// Get a list of apartment
	public ArrayList<Apartment> getAvailableApartmentList();
	// Add a apartment
	public boolean addApartment(Apartment apartment);
	// Update a apartment
	public boolean updateApartment(Apartment apartment);
	// Delete a apartment
	public boolean deleteApartment(int apid);

}
