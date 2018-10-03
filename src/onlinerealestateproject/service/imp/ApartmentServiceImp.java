package onlinerealestateproject.service.imp;

import java.util.ArrayList;

import onlinerealestateproject.datasource.ApartmentLockMapper;
import onlinerealestateproject.datasource.ApartmentMapper;
import onlinerealestateproject.datasource.imp.ApartmentLockMapperImpl;
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
		UnitofWorkApartment.newCurrent();
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		ApartmentLockMapper apartmentLockMapper = new ApartmentLockMapperImpl(apartmentMapper);
		return apartmentLockMapper.find(apid);
	}
	
	public ArrayList<Apartment> getAvailableApartmentList(){
    	UnitofWorkApartment.newCurrent();
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		ApartmentLockMapper apartmentLockMapper = new ApartmentLockMapperImpl(apartmentMapper);
		return apartmentLockMapper.findAllApartments();
	}
	
	public boolean addApartment(Apartment apartment) {
		UnitofWorkApartment.newCurrent();
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		ApartmentLockMapper apartmentLockMapper = new ApartmentLockMapperImpl(apartmentMapper);
		
		if(apartmentLockMapper.insert(apartment)) {
			return true;
		}
		return false;
	}
	
	public boolean updateApartment(Apartment apartment) {
		UnitofWorkApartment.newCurrent();
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		ApartmentLockMapper apartmentLockMapper = new ApartmentLockMapperImpl(apartmentMapper);
		
		if(apartmentLockMapper.update(apartment)) {
			return true;
		}
		return false;
	}
	
	public boolean deleteApartment(int apid) {
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		ApartmentLockMapper apartmentLockMapper = new ApartmentLockMapperImpl(apartmentMapper);
		if(apartmentLockMapper.delete(apid)) {
			return true;
		}
		return false;
	}

}
