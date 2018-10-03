package onlinerealestateproject.dto;

import java.util.ArrayList;

import onlinerealestateproject.datasource.ApartmentLockMapper;
import onlinerealestateproject.datasource.ApartmentMapper;
import onlinerealestateproject.datasource.imp.ApartmentLockMapperImpl;
import onlinerealestateproject.datasource.imp.ApartmentMapperImpl;
import onlinerealestateproject.domain.Apartment;
import onlinerealestateproject.util.UnitofWorkApartment;

/**
 * @author haomai
 * An apartment assembler object
 */

public class ApartmentAssembler {
	
	public static ApartmentDTO writeDTO(Apartment apartment) {
		UnitofWorkApartment.newCurrent();
		ApartmentDTO result = new ApartmentDTO(apartment.getApid(), 
				apartment.getStartRentTime(), apartment.getEndRentTime(), 
				apartment.getAvailability(), apartment.getPrice(),
				apartment.getAcreage(), apartment.getLocation(),
				apartment.getApartmentName());
		return result;
	}
	
	public static ArrayList<ApartmentDTO> writeDTOList(){
		UnitofWorkApartment.newCurrent();
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		ApartmentLockMapper apartmentLockMapper = new ApartmentLockMapperImpl(apartmentMapper);
		ArrayList<Apartment> apartmentList = apartmentLockMapper.findAllApartments();
		ArrayList<ApartmentDTO> result = new ArrayList<ApartmentDTO>();
		for(Apartment apartment : apartmentList) {
			ApartmentDTO temp = writeDTO(apartment);
			result.add(temp);
		}
		return result;
	}
	
	public static void updateApartment(int apid, ApartmentDTO dto) {
		UnitofWorkApartment.newCurrent();
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		ApartmentLockMapper apartmentLockMapper = new ApartmentLockMapperImpl(apartmentMapper);
		Apartment apartment = apartmentLockMapper.find(apid);
		if(apartment == null)
			throw new RuntimeException("Apartment does not exist: " + dto.getApartmentName());
		apartment.setStartRentTime(dto.getStartRentTime());
		apartment.setEndRentTime(dto.getEndRentTime());
		apartment.setAvailability(dto.getAvailability());
		apartment.setPrice(dto.getPrice());
		apartment.setAcreage(dto.getAcreage());
		apartment.setLocation(dto.getLocation());
		apartment.setApartmentName(dto.getApartmentName());
		
		apartmentLockMapper.update(apartment);
	}
	
	public static void createApartment(ApartmentDTO dto) {
		UnitofWorkApartment.newCurrent();
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		ApartmentLockMapper apartmentLockMapper = new ApartmentLockMapperImpl(apartmentMapper);
		Apartment apartment = new Apartment(dto.getApid(), 
				dto.getStartRentTime(), dto.getEndRentTime(), 
				dto.getAvailability(), dto.getPrice(), 
				dto.getAcreage(), dto.getLocation(), 
				dto.getApartmentName());
		
		apartmentLockMapper.insert(apartment);
	}
	
	public static void deleteApartment(int apid) {
		UnitofWorkApartment.newCurrent();
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		ApartmentLockMapper apartmentLockMapper = new ApartmentLockMapperImpl(apartmentMapper);
		apartmentLockMapper.delete(apid);
	}

}
