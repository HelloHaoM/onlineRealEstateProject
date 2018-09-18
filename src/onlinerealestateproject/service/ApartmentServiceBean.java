package onlinerealestateproject.service;

import java.rmi.RemoteException;

import onlinerealestateproject.dto.ApartmentDTO;

/**
 * @author haomai
 * A remote apartment service interface
 */

public interface ApartmentServiceBean {
	public ApartmentDTO getApartment(int apid) throws RemoteException;
	public void createApartment(ApartmentDTO dto) throws RemoteException;
	public void updateApartment(int apid, ApartmentDTO dto) throws RemoteException;
	public void deleteApartment(int apid) throws RemoteException;

}
