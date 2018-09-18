package onlinerealestateproject.service;

import java.rmi.RemoteException;

import onlinerealestateproject.dto.UserDTO;

public interface UserServiceBean {
	public UserDTO getUser(String id) throws RemoteException;
	public void updateUser(String id, UserDTO dto) throws RemoteException;
}
