package onlinerealestateproject.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import onlinerealestateproject.datasource.DataMapperException;
import onlinerealestateproject.datasource.TestLogin;

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
	
	private int order;
	
	private String permission;
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public User(int uid, String firstName, String lastName,
			String userName, String password, int oid, String permission) {
		this.uid = uid;
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.userName = userName;
		this.password = password;
		this.order = oid;
		this.permission = permission;
	}
	
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
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
	
	public boolean findUP(String userName, String password) {
		TestLogin tl1 = new TestLogin();
		if(tl1.find(userName, password)) {
			return true;
		}
		return false;
		
	}
	
			
			
}
