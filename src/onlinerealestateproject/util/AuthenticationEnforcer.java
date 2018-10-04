package onlinerealestateproject.util;

import onlinerealestateproject.domain.Client;

public class AuthenticationEnforcer {

	String username;
	String password;
	static String cipherpassword;
	static String key = "Bar19346Bcr12345";
	static String randomnumber = "RandomInitVector";

	public AuthenticationEnforcer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public static String encryptpassword(String password) {
		SecurityManager sm = new SecurityManager();
		cipherpassword = sm.encrypt(key, randomnumber, password);
		return cipherpassword;
	}

	public static boolean findByAccount(String username, String cipherpassword) {
		ToolFind tf = new ToolFind();
		if(tf.findByAccount(username, cipherpassword)) {
			Client client = new Client(username, cipherpassword);
			return true;
		}
		else 
			return false;
	}

}
