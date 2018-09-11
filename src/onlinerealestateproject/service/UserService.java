package onlinerealestateproject.service;

/**
 * @author haomai
 * A user service interface
 */

public interface UserService {
	// find a user id
	public int findUserId(String userName, String password);
	// log in 
	public boolean login(String userName, String password);
	// log in as administrator
	public boolean admLogin(String userName, String password);
	// register 
	public boolean register(String firstName, String lastName, String userName, String password);

}
