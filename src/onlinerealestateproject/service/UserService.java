package onlinerealestateproject.service;

/**
 * @author haomai
 * A user service interface
 */

public interface UserService {
	
	public boolean Login(String userName, String password);
	public boolean register(String firstName, String lastName, String userName, String password);

}
