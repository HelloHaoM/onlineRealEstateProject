package onlinerealestateproject.util;

import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Client;
import onlinerealestateproject.domain.Order;
import onlinerealestateproject.domain.User;

/**
 * @author haomai
 * A factory to generate client or administrator
 */
public class UserFactory {
	
	public static User createSimpleUser(String type, String userName, String password) {
		switch(type) {
		case "client":
			return new Client(userName, password);
			
		case "administrator":
			return new Administrator(userName, password);
			
		default:
			break;
		}
		return null;
	}
	
	public static User createUser(String type,
			int uid, String firstName, String lastName,
			String userName, String password, int order, String permission) {
		switch(type) {
		
		case "client":
			return new Client(uid, firstName, lastName,
					userName, password, order, permission);
			
		case "administrator":
			return new Administrator(uid, firstName, lastName,
					userName, password, order, permission);
			
		default:
			break;
			
		}
		return null;
	}

}
