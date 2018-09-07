package onlinerealestateproject.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import onlinerealestateproject.datasource.ClientMapperImpl;
import onlinerealestateproject.datasource.DataMapperException;
import onlinerealestateproject.datasource.TestLogin;
import onlinerealestateproject.datasource.TestRegister;
import onlinerealestateproject.datasource.UserMapperImpl;

/**
 * @author haomai
 * A high level user object
 */
public class User {
	
	public int uid;
	public String firstName;
	public String lastName;
	
	public String userName;
	public String password;
	
	public int order;
	
	public String permission;
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public User(int uid, String firstName, String lastName,
			String userName, String password, int oid, String permission) {
//		this.uid = uid;
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

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
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
	
	public boolean register(int Aid, String firstName, String lastName, String userName,String password) {
		TestRegister tr1 = new TestRegister();
		if(!tr1.find(userName)) {
			tr1.insert(Aid,firstName,lastName,userName,password);
			return true;
		}else {
			System.out.print("username is not available");
			return false;
			
		}
		
	}
	public User find(int id) {
		
		UserMapperImpl userMapperImpl = new UserMapperImpl();
		return userMapperImpl.find(id, "user");
		
	}
	
	
	public void insert (User user) throws DataMapperException{
		
		UserMapperImpl userMapperImpl = new UserMapperImpl();
		userMapperImpl.insert(user);;
	}
	
	
	public void update (User user) throws DataMapperException{
		
		UserMapperImpl userMapperImpl = new UserMapperImpl();
		userMapperImpl.update(user);;
	}
	
	
	public void delete (User user) throws DataMapperException{
		
		UserMapperImpl userMapperImpl = new UserMapperImpl();
		userMapperImpl.delete(user);;
	}
	
			
			
}
