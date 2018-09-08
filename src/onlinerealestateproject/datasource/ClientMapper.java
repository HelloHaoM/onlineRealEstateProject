package onlinerealestateproject.datasource;

import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Client;
/**
 * @author Junjie Huang
 * 
 */
public interface ClientMapper {

	public Client find(int id);
	public boolean isFind(String username, String password);
	public int findIdByAccount(String username, String password);
	public boolean insert (Client client) throws DataMapperException;
	public boolean update (Client client) throws DataMapperException;
	public boolean delete (Client client) throws DataMapperException;

}
