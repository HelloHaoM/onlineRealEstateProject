package onlinerealestateproject.domain;

import java.util.ArrayList;

/**
 * @author haomai
 * A administrator object extends user object
 */
public class Administrator extends User{
	
	private ArrayList<Apartment> appartmentList;

	public Administrator(int aid, String firstName, String lastName, 
			String userName, String password, int oid, 
			String permission/*, ArrayList<Apartment> appartmentList*/) {
		super(aid, firstName, lastName, userName, password, oid, permission);
		//this.appartmentList = new ArrayList<Apartment>(appartmentList);
	}
	
	
	public Administrator(String userName, String password) {
		super(userName, password);
	}


	
	
}
