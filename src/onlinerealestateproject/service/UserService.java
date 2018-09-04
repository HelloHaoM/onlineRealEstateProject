package onlinerealestateproject.service;

/**
 * @author haomai
 * A user service interface
 */

public interface UserService {
	
	public boolean Login(String userName, String password);
	public String register(String userName, String password);

}
