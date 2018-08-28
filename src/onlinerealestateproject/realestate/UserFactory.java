package onlinerealestateproject.realestate;

import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Client;
import onlinerealestateproject.domain.User;

/**
 * @author haomai
 * A factory to generate client or administrator
 */
public class UserFactory {
	
	public User createUser(String type,
			int uid, String firstName, String lastName,
			String userName, String password, String permission) {
		switch(type) {
		
		case "client":
			return new Client(uid, firstName, lastName,
					userName, password, permission);
			
		case "administrator":
			return new Administrator(uid, firstName, lastName,
					userName, password, permission);
			
		default:
			break;
			
		}
		return null;
	}

}
