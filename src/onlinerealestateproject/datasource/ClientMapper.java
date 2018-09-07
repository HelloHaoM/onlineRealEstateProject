package onlinerealestateproject.datasource;

import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Client;
/**
 * @author Junjie Huang
 * 
 */
public interface ClientMapper {

	public Client find(int id);
	public void insert (Client client) throws DataMapperException;
	public void update (Client client) throws DataMapperException;
	public void delete (Client client) throws DataMapperException;

}
