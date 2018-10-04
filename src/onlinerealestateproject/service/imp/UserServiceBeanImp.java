package onlinerealestateproject.service.imp;

import java.rmi.RemoteException;

import onlinerealestateproject.datasource.UserMapper;
import onlinerealestateproject.datasource.imp.UserMapperImpl;
import onlinerealestateproject.dto.UserAssembler;
import onlinerealestateproject.dto.UserDTO;
import onlinerealestateproject.service.UserServiceBean;

public class UserServiceBeanImp implements UserServiceBean{

	@Override
	public UserDTO getUser(int id) throws RemoteException {
		// TODO Auto-generated method stub
		UserMapper userMapper = new UserMapperImpl();
		return new UserAssembler().writeDTO(userMapper.find(id));
	}

	@Override
	public void createUser(UserDTO dto) throws RemoteException {
		// TODO Auto-generated method stub
		new UserAssembler().createUser(dto);
	}

	@Override
	public void updateUser(int id, UserDTO dto) throws RemoteException {
		// TODO Auto-generated method stub
		new UserAssembler().updateUser(id, dto);	
	}

	@Override
	public byte[] getUserByte(int id) throws RemoteException {
		// TODO Auto-generated method stub
		UserMapper userMapper = new UserMapperImpl();
		return UserDTO.object2Byte(new UserAssembler().writeDTO(userMapper.find(id)));
	}

	@Override
	public void createUserByByte(byte[] userByte) throws RemoteException {
		// TODO Auto-generated method stub
		new UserAssembler().createUser(UserDTO.byte2Object(userByte));
		
	}

	@Override
	public void uppdateUserByByte(int id, byte[] userByte) throws RemoteException {
		// TODO Auto-generated method stub
		new UserAssembler().updateUser(id, UserDTO.byte2Object(userByte));
	}

}
