package onlinerealestateproject.service.imp;

import java.rmi.RemoteException;

import onlinerealestateproject.datasource.ApartmentMapper;
import onlinerealestateproject.datasource.imp.ApartmentMapperImpl;
import onlinerealestateproject.dto.ApartmentAssembler;
import onlinerealestateproject.dto.ApartmentDTO;
import onlinerealestateproject.service.ApartmentServiceBean;

public class ApartmentServiceBeanImp implements ApartmentServiceBean{

	@Override
	public ApartmentDTO getApartment(int apid) throws RemoteException {
		// TODO Auto-generated method stub
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		return new ApartmentAssembler().writeDTO(apartmentMapper.find(apid));
	}

	@Override
	public void createApartment(ApartmentDTO dto) throws RemoteException {
		// TODO Auto-generated method stub
		new ApartmentAssembler().createApartment(dto);
		
	}

	@Override
	public void updateApartment(int apid, ApartmentDTO dto) throws RemoteException {
		// TODO Auto-generated method stub
		new ApartmentAssembler().updateApartment(apid, dto);
	}

	@Override
	public void deleteApartment(int apid) throws RemoteException {
		// TODO Auto-generated method stub
		new ApartmentAssembler().deleteApartment(apid);
	}

}
