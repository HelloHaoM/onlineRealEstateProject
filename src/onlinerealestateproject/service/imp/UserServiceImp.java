package onlinerealestateproject.service.imp;

import onlinerealestateproject.datasource.AdministratorMapper;
import onlinerealestateproject.datasource.ClientMapper;
import onlinerealestateproject.datasource.UserMapper;
import onlinerealestateproject.datasource.imp.AdministratorMapperImpl;
import onlinerealestateproject.datasource.imp.ClientMapperImpl;
import onlinerealestateproject.datasource.imp.UserMapperImpl;
import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Client;
import onlinerealestateproject.domain.User;
import onlinerealestateproject.service.UserService;
import onlinerealestateproject.util.UserFactory;

/**
 * @author haomai
 * A service for user to log in and register
 */
public class UserServiceImp implements UserService {
	
	public int findUserId(String userName, String password) {
		ClientMapper clientMapper = new ClientMapperImpl();
		return clientMapper.findIdByAccount(userName, password);
	}
	
	public boolean login(String userName, String password) {
		
		ClientMapper clientMapper = new ClientMapperImpl();
		
		// find by client mapper
		if(clientMapper.isFind(userName, password)) {
			// create a new client using factory
			Client client = (Client) UserFactory.createSimpleUser("client", userName, password);
			return true;
		}
		return false;
		
	}
	
	public boolean admLogin(String userName, String password) {
		
		AdministratorMapper administratorMapper = new AdministratorMapperImpl();
		
		// find by client mapper
		if(administratorMapper.isFind(userName, password)) {
			// create a new client using factory
			Administrator administrator = (Administrator) UserFactory.createSimpleUser("administrator", userName, password);
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
