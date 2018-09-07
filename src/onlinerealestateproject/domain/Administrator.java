package onlinerealestateproject.domain;

import java.util.ArrayList;

import onlinerealestateproject.datasource.AdministratorMapperImpl;
import onlinerealestateproject.datasource.DataMapperException;

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
	public Administrator find(int id) {
		
		AdministratorMapperImpl administratorMapperImpl = new AdministratorMapperImpl();
		return administratorMapperImpl.find(id);
		
	}
	
	
	public void insert (Administrator administrator) throws DataMapperException{
		
		AdministratorMapperImpl administratorMapperImpl = new AdministratorMapperImpl();
		administratorMapperImpl.insert(administrator);
	}
	
	
	public void update (Administrator administrator) throws DataMapperException{
		
		AdministratorMapperImpl administratorMapperImpl = new AdministratorMapperImpl();
		administratorMapperImpl.update(administrator);;
	}
	
	
	public void delete (Administrator administrator) throws DataMapperException{
		
		AdministratorMapperImpl administratorMapperImpl = new AdministratorMapperImpl();
		administratorMapperImpl.delete(administrator);;
	}


	
	
}
