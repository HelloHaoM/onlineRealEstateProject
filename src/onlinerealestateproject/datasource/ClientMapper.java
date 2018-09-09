package onlinerealestateproject.datasource;

import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Client;
/**
 * @author Junjie Huang
 * 
 */
public interface ClientMapper {

	// find a client by an id
	public Client find(int id);
	// can find or not
	public boolean isFind(String username, String password);
	// find a client by username and password
	public int findIdByAccount(String username, String password);
	// insert a client
	public boolean insert (Client client) throws DataMapperException;
	// update a client
	public boolean update (Client client) throws DataMapperException;
	// delete a client
	public boolean delete (Client client) throws DataMapperException;

}
