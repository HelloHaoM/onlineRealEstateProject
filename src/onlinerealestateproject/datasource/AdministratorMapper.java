package onlinerealestateproject.datasource;

import onlinerealestateproject.domain.Administrator;

public interface AdministratorMapper {
	
	public Administrator find(int aid);
	public void insert (Administrator administrator) throws DataMapperException;
	public void update (Administrator administrator) throws DataMapperException;
	public void delete (Administrator administrator) throws DataMapperException;
	

}
