package onlinerealestateproject.service;

import java.rmi.RemoteException;

import onlinerealestateproject.dto.UserDTO;

/**
 * @author haomai
 * A remote user service interface
 */

public interface UserServiceBean {
	public UserDTO getUser(int id) throws RemoteException;
	public void createUser(UserDTO dto) throws RemoteException;
	public void updateUser(int id, UserDTO dto) throws RemoteException;
}
