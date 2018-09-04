package onlinerealestateproject.domain;

/**
 * @author haomai
 * A administrator object extends user object
 */
public class Administrator extends User{
	
	private String permission;

	public Administrator(int aid, String firstName, String lastName, 
			String userName, String password, int oid, String permission) {
		super(aid, firstName, lastName, userName, password, oid);
		this.permission = permission;
	}
	
	
	
	
}
