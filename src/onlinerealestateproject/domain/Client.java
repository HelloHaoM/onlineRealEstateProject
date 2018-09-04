package onlinerealestateproject.domain;

/**
 * @author haomai
 * A client object extends User object
 */
public class Client extends User{
	
	private InspectionCart cart;

	public Client(int cid, String firstName, String lastName, 
			String userName, String password, int order, 
			String permission, InspectionCart cart) {
		super(cid, firstName, lastName, userName, password, order, permission);
		this.cart = cart;
	}
	
	public Client(String firstName, String lastName) {
		super(firstName,lastName);
	}

}
