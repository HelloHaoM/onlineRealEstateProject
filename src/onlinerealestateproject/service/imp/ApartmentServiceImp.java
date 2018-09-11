package onlinerealestateproject.service.imp;

import java.util.ArrayList;

import onlinerealestateproject.datasource.ApartmentMapper;
import onlinerealestateproject.datasource.imp.ApartmentMapperImpl;
import onlinerealestateproject.domain.Apartment;
import onlinerealestateproject.service.ApartmentService;
import onlinerealestateproject.util.UnitofWorkApartment;

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
	
	public boolean addApartment(Apartment apartment) {
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		
		if(apartmentMapper.insert(apartment)) {
			return true;
		}
		return false;
	}
	
	public boolean updateApartment(Apartment apartment) {
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();

		if(apartmentMapper.update(apartment)) {
			return true;
		}
		return false;
	}
	
	public boolean deleteApartment(int apid) {
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		if(apartmentMapper.delete(apid)) {
			return true;
		}
		return false;
	}

}
