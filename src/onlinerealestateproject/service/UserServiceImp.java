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
		// create a new client using factory
		Client client = (Client) UserFactory.createSimpleUser("client", userName, password);
		ClientMapper clientMapper = new ClientMapperImpl();
		
		// find by client mapper
		if(clientMapper.isFind(userName, password)) {
			return true;
		}
		return false;
		
	}
	
	public boolean register(String firstName, String lastName, String userName, String password) {
		// create a client and the id and oid is defined to 999 and 0(which are default)
		Client client = (Client) UserFactory.createUser("client", 999, firstName, lastName, userName, password, 0, "client");
		ClientMapper clientMapper = new ClientMapperImpl();
		
		// insert by client mapper
		if(clientMapper.insert(client)) {
			return true;
		}
		return false;
		
	}


}
