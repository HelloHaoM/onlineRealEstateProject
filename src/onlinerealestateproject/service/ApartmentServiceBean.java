package onlinerealestateproject.service;

import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import onlinerealestateproject.dto.ApartmentDTO;

/**
 * @author haomai
 * A remote apartment service interface
 */

public interface ApartmentServiceBean {
	public ApartmentDTO getApartment(int apid) throws RemoteException;
	public byte[] getApartmentByte(int apid) throws RemoteException;
	public ArrayList<byte[]> getApartmentByteList() throws RemoteException;
	public void createApartment(ApartmentDTO dto) throws RemoteException;
	public void createApartmentByByte(byte[] apartmentByte) throws RemoteException;
	public void updateApartment(int apid, ApartmentDTO dto) throws RemoteException;
	public void updateApartmentByByte(int apid, byte[] apartmentByte) throws RemoteException;
	public void deleteApartment(int apid) throws RemoteException;

}
