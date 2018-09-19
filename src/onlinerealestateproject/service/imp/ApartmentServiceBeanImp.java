package onlinerealestateproject.service.imp;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import onlinerealestateproject.datasource.ApartmentMapper;
import onlinerealestateproject.datasource.imp.ApartmentMapperImpl;
import onlinerealestateproject.dto.ApartmentAssembler;
import onlinerealestateproject.dto.ApartmentDTO;
import onlinerealestateproject.service.ApartmentServiceBean;
import onlinerealestateproject.util.UnitofWorkApartment;

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

	@Override
	public byte[] getApartmentByte(int apid) throws RemoteException {
		// TODO Auto-generated method stub
		UnitofWorkApartment.newCurrent();
		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
		return ApartmentDTO.object2Byte(new ApartmentAssembler().writeDTO(apartmentMapper.find(apid)));
	}

	@Override
	public void createApartmentByByte(byte[] apartmentByte) throws RemoteException {
		// TODO Auto-generated method stub
		new ApartmentAssembler().createApartment(ApartmentDTO.byte2Object(apartmentByte));
		
	}

	@Override
	public void updateApartmentByByte(int apid, byte[] apartmentByte) throws RemoteException {
		// TODO Auto-generated method stub
		new ApartmentAssembler().updateApartment(apid, ApartmentDTO.byte2Object(apartmentByte));
	}

	@Override
	public ArrayList<byte[]> getApartmentByteList() throws RemoteException {
		// TODO Auto-generated method stub
		return ApartmentDTO.objectList2ByteList(new ApartmentAssembler().writeDTOList());
		
	}

}
