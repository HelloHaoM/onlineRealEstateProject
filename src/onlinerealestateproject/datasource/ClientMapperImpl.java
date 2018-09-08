package onlinerealestateproject.datasource;

import java.awt.List;

import onlinerealestateproject.domain.Client;
import onlinerealestateproject.util.ToolDelete;
import onlinerealestateproject.util.ToolFind;
import onlinerealestateproject.util.ToolInsert;
import onlinerealestateproject.util.ToolUpdate;
/**
 * @author Junjie Huang
 * 
 */
public class ClientMapperImpl implements ClientMapper {

	@Override
	public boolean isFind(String username, String password) {
		// TODO Auto-generated method stub
		ToolFind tf = new ToolFind();
		if(tf.findByAccount(username, password))
			return true;
		return false;
	}
	
	@Override
	public Client find(int id) {
		// TODO Auto-generated method stub
		ToolFind tf = new ToolFind();
		return tf.findClient(id);

	}

	@Override
	public boolean insert(Client client) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolInsert ti = new ToolInsert();
		if(ti.insertUAC(client.uid, client.firstName, client.lastName, client.userName, client.password, client.order, client.permission, "client"))
			return true;
		return false;
		
		
	}

	@Override
	public boolean update(Client client) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolUpdate tu = new ToolUpdate();
		if(tu.updateUAC(client.uid, client.firstName, client.lastName,
				client.userName, client.password,client.order,client.permission, "client"))
			return true;
		return false;
	
	}

	@Override
	public boolean delete(Client client) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolDelete td = new ToolDelete();
		if(td.delete(client.getUid(), "client"))
			return true;
		return false;
	}


	

	
	
	
}
