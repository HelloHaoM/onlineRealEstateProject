package onlinerealestateproject.domain;

/**
 * @author haomai
 * A high level user object
 */
public class User {
	
	private int uid;
	private String firstName;
	private String lastName;
	
	private String userName;
	private String password;
	
	public User(int uid, String firstName, String lastName,
			String userName, String password) {
		this.uid = uid;
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.userName = userName;
		this.password = password;
	}
	
	private void load() {
		
	}

	public int getUid() {
		if(this.uid == -1)
			load();
		return this.uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		if(this.firstName == null)
			load();
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		if(this.lastName == null)
			load();
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		if(this.userName == null)
			load();
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		if(this.password == null)
			load();
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
