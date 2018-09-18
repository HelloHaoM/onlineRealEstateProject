package onlinerealestateproject.dto;

import onlinerealestateproject.datasource.ApartmentMapper;
import onlinerealestateproject.datasource.imp.ApartmentMapperImpl;
import onlinerealestateproject.domain.Apartment;
import onlinerealestateproject.util.UnitofWorkApartment;

/**
 * @author haomai
 * An apartment assembler object
 */

public class ApartmentAssembler {
	
	public static ApartmentDTO writeDTO(Apartment apartment) {
		ApartmentDTO result = new ApartmentDTO(apartment.getApid(), 
				apartment.getStartRentTime(), apartment.getEndRentTime(), 
				apartment.getAvailability(), apartment.getPrice(),
				apartment.getAcreage(), apartment.getLocation(),
				apartment.getApartmentName());
		return result;
	}
	
	public static void updateApartment(int apid, ApartmentDTO dto) {
		UnitofWorkApartment.newCurrent();
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		Apartment apartment = apartmentMapper.find(apid);
		if(apartment == null)
			throw new RuntimeException("Apartment does not exist: " + dto.getApartmentName());
		apartment.setStartRentTime(dto.getStartRentTime());
		apartment.setEndRentTime(dto.getEndRentTime());
		apartment.setAvailability(dto.getAvailability());
		apartment.setPrice(dto.getPrice());
		apartment.setAcreage(dto.getAcreage());
		apartment.setLocation(dto.getLocation());
		apartment.setApartmentName(dto.getApartmentName());
		
		apartmentMapper.update(apartment);
	}
	
	public static void createApartment(ApartmentDTO dto) {
		UnitofWorkApartment.newCurrent();
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		Apartment apartment = new Apartment(dto.getApid(), 
				dto.getStartRentTime(), dto.getEndRentTime(), 
				dto.getAvailability(), dto.getPrice(), 
				dto.getAcreage(), dto.getLocation(), 
				dto.getApartmentName());
		
		apartmentMapper.insert(apartment);
	}
	
	public static void deleteApartment(int apid) {
		UnitofWorkApartment.newCurrent();
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		apartmentMapper.delete(apid);
	}

}
