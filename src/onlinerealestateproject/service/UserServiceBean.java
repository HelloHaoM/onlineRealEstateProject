package onlinerealestateproject.service;

import java.rmi.RemoteException;

import onlinerealestateproject.dto.UserDTO;

/**
 * @author haomai
 * A remote user service interface
 */

public interface UserServiceBean {
	public UserDTO getUser(int id) throws RemoteException;
	public byte[] getUserByte(int id) throws RemoteException;
	public void createUser(UserDTO dto) throws RemoteException;
	public void createUserByByte(byte[] userByte) throws RemoteException;
	public void updateUser(int id, UserDTO dto) throws RemoteException;
	public void uppdateUserByByte(int id, byte[] userByte) throws RemoteException;
}
