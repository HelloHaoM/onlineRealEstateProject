package onlinerealestateproject.domain;

/**
 * @author haomai
 * A administrator object extends user object
 */
public class Administrator extends User{
	
	private String permission;

	public Administrator(int uid, String firstName, String lastName, 
			String userName, String password, String permission) {
		super(uid, firstName, lastName, userName, password);
		this.permission = permission;
	}

}
