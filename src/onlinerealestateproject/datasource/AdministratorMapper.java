package onlinerealestateproject.datasource;

import onlinerealestateproject.domain.Administrator;
/**
 * @author Junjie Huang
 * 
 */
public interface AdministratorMapper {
	
	public Administrator find(int id);
	public void insert (Administrator administrator) throws DataMapperException;
	public void update (Administrator administrator) throws DataMapperException;
	public void delete (Administrator administrator) throws DataMapperException;
	

}
