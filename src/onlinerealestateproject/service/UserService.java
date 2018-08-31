package onlinerealestateproject.service;

/**
 * @author haomai
 * A user service interface
 */

public interface UserService {
	
	public String Login(String userName, String password);
	public String register(String userName, String password);

}
