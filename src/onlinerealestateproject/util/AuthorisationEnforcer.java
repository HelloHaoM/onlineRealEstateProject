package onlinerealestateproject.util;

import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Client;

public class AuthorisationEnforcer {

	String permission;
	String username;
	String password;

	public AuthorisationEnforcer(String permission,String username,String password) {
		super();
		this.username = username;
		this.permission = permission;
		this.password = password;
	}

	public boolean checkpermission(String permission) {
		if (permission == "administrator") {
			return true;
		} else
			return false;

	}

	public void getCredentialClient(Client client) {
		username = client.getUserName();
		password = client.getPassword();
	}

	public void getCredentialAdmin(Administrator admin) {
		username = admin.getUserName();
		password = admin.getPassword();
	}
	
	public void getPermissionAdmin(Administrator admin) {
		permission = admin.getPermission();
	}
	
	public void getPermissionClient(Client client) {
		permission = client.getPermission();
	}
	
}
