package onlinerealestateproject.service.imp;

import java.util.ArrayList;

import onlinerealestateproject.datasource.ApartmentMapper;
import onlinerealestateproject.datasource.imp.ApartmentMapperImpl;
import onlinerealestateproject.domain.Apartment;
import onlinerealestateproject.service.ApartmentService;

/**
 * @author haomai
 * A apartment service interface implementation
 */

public class ApartmentServiceImp implements ApartmentService{
	
	public Apartment getApartment(int apid) {
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		return apartmentMapper.find(apid);
	}
	
	public ArrayList<Apartment> getAvailableApartmentList(){
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		return apartmentMapper.findAllApartments();
	}

}
