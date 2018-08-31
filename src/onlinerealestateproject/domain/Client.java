package onlinerealestateproject.domain;

/**
 * @author haomai
 * A client object extends User object
 */
public class Client extends User{
	
	private String permission;

	public Client(int uid, String firstName, String lastName, 
			String userName, String password, Order order, String permission) {
		super(uid, firstName, lastName, userName, password, order);
		this.permission = permission;
	}
	

}
