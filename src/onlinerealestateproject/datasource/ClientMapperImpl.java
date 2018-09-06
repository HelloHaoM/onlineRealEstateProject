package onlinerealestateproject.datasource;

import java.awt.List;

import onlinerealestateproject.domain.Client;

public class ClientMapperImpl implements ClientMapper {

	@Override
	public Client find(String statement, String tablename) {
		// TODO Auto-generated method stub
		ToolFind tf = new ToolFind();
		return tf.findClient("");

	}

	@Override
	public void insert(Client client) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolInsert ti = new ToolInsert();
		ti.insertUAC(client.uid, client.firstName, client.lastName, client.userName, client.password, client.order, client.permission, "client");
		
	}

	@Override
	public void update(Client client) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolUpdate tu = new ToolUpdate();
		tu.updateUAC(client.uid, client.firstName, client.lastName,
				client.userName, client.password,client.order,client.permission, "client");
	
	}

	@Override
	public void delete(Client client) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolDelete td = new ToolDelete();
		td.delete(1, "client");
	}
	

	
	
	
}
