package onlinerealestateproject.service;

import onlinerealestateproject.domain.User;
import onlinerealestateproject.realestate.UserFactory;

/**
 * @author haomai
 * A service for user to log in and register
 */
public class UserServiceImp implements UserService {
	
	public boolean Login(String userName, String password) {
		User user = UserFactory.createSimpleUser("client", userName, password);
		if(user.findUP(userName, password)) {
			return true;
		}
		return false;
		
	}
	
	public String register(String userName, String password) {
		return null;
	}

}
