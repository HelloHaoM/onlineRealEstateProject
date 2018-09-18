package onlinerealestateproject.dto;

import onlinerealestateproject.datasource.ApartmentMapper;
import onlinerealestateproject.datasource.imp.ApartmentMapperImpl;
import onlinerealestateproject.domain.Apartment;

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
	
	public static void updateApartment(String apid, ApartmentDTO dto) {
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		Apartment apartment = apartmentMapper.find(Integer.parseInt(apid));
		if(apartment == null)
			throw new RuntimeException("Apartment does not exist: " + dto.getApartmentName());
		apartment.setStartRentTime(dto.getStartRentTime());
		apartment.setEndRentTime(dto.getEndRentTime());
		apartment.setAvailability(dto.getAvailability());
		apartment.setPrice(dto.getPrice());
		apartment.setAcreage(dto.getAcreage());
		apartment.setLocation(dto.getLocation());
		apartment.setApartmentName(dto.getApartmentName());
	}

}
