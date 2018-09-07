package onlinerealestateproject.service;

import onlinerealestateproject.datasource.ClientMapper;
import onlinerealestateproject.datasource.ClientMapperImpl;
import onlinerealestateproject.domain.Client;
import onlinerealestateproject.domain.User;
import onlinerealestateproject.realestate.UserFactory;

/**
 * @author haomai
 * A service for user to log in and register
 */
public class UserServiceImp implements UserService {
	
	public boolean Login(String userName, String password) {
		Client client = (Client) UserFactory.createSimpleUser("client", userName, password);
		ClientMapper clientMapper = new ClientMapperImpl();
		
		if(clientMapper.isFind(userName, password)) {
			return true;
		}
		return false;
		
	}
	
	public boolean register(String firstName, String lastName, String userName, String password) {
		Client client = (Client) UserFactory.createUser("client", -1, firstName, lastName, userName, password, 0, "client");
		ClientMapper clientMapper = new ClientMapperImpl();
		
		if(clientMapper.insert(client)) {
			return true;
		}
		return false;
		
	}


}
