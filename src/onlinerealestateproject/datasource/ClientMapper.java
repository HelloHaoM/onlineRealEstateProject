package onlinerealestateproject.datasource;

import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Client;

public interface ClientMapper {

	public Client find(String statement, String tablename);
	public void insert (Client client) throws DataMapperException;
	public void update (Client client) throws DataMapperException;
	public void delete (Client client) throws DataMapperException;

}
