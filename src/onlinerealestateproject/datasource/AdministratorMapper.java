package onlinerealestateproject.datasource;

import onlinerealestateproject.domain.Administrator;
/**
 * @author Junjie Huang
 * 
 */
public interface AdministratorMapper {
	
	// find an administrator by an id
	public Administrator find(int id);
	// can find or not
	public boolean isFind(String username, String password);
	// insert an administrator
	public boolean insert (Administrator administrator) throws DataMapperException;
	// update an administrator
	public boolean update (Administrator administrator) throws DataMapperException;
	// delete an administrator
	public boolean delete (Administrator administrator) throws DataMapperException;
	

}
