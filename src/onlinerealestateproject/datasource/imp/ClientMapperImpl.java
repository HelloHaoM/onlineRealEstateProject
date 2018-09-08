package onlinerealestateproject.datasource.imp;

import java.awt.List;

import onlinerealestateproject.datasource.ClientMapper;
import onlinerealestateproject.datasource.DataMapperException;
import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Client;
import onlinerealestateproject.util.IdentityMap;
import onlinerealestateproject.util.ToolDelete;
import onlinerealestateproject.util.ToolFind;
import onlinerealestateproject.util.ToolInsert;
import onlinerealestateproject.util.ToolUpdate;
/**
 * @author Junjie Huang
 * 
 */
public class ClientMapperImpl implements ClientMapper {
	
	Client client = new Client(0, null, null, null, null, 0, null);
	IdentityMap<Client> map = IdentityMap.getInstance(client);
	
	@Override
	public boolean isFind(String username, String password) {
		// TODO Auto-generated method stub
		ToolFind tf = new ToolFind();
		if(tf.findByAccount(username, password))
			return true;
		return false;
	}
	
	@Override
	public int findIdByAccount(String username, String password) {
		// TODO Auto-generated method stub
		ToolFind tf = new ToolFind();
		return tf.findIdByAccount(username, password);
	}
	
	@Override
	public Client find(int id) {
		// TODO Auto-generated method stub
		ToolFind tf = new ToolFind();
		map.put(id, tf.findClient(id));
		return map.get(id);

	}

	@Override
	public boolean insert(Client client) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolInsert ti = new ToolInsert();
		
		if(ti.insertUAC(client.uid, client.firstName, client.lastName, client.userName, client.password, client.order, client.permission, "client"))
			{
			map.put(client.getUid(),client);
			return true;
			}
		return false;
		
		
	}

	@Override
	public boolean update(Client client) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolUpdate tu = new ToolUpdate();
		if(map.get(client.getUid())!=null){
			map.put(client.getUid(), client);
			
			if(tu.updateUAC(client.uid, client.firstName, client.lastName,
					client.userName, client.password,client.order,client.permission, "client"))
				return true;
			return false;
		}
		return false;
	}

	@Override
	public boolean delete(Client client) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolDelete td = new ToolDelete();
		if(map.get(client.getUid())!=null){
			map.put(client.getUid(), null);
			if(td.delete(client.getUid(), "client"))
				return true;
			return false;
		}
		return false;
	}


	

	
	
	
}
