package onlinerealestateproject.datasource;

import onlinerealestateproject.domain.Administrator;
/**
 * @author Junjie Huang
 * 
 */
public interface AdministratorMapper {
	
	public Administrator find(int id);
	public boolean insert (Administrator administrator) throws DataMapperException;
	public boolean update (Administrator administrator) throws DataMapperException;
	public boolean delete (Administrator administrator) throws DataMapperException;
	

}
