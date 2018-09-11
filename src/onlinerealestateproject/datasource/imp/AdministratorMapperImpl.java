package onlinerealestateproject.datasource.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import onlinerealestateproject.datasource.AdministratorMapper;
import onlinerealestateproject.datasource.DataMapperException;
import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Client;
import onlinerealestateproject.domain.Order;
import onlinerealestateproject.util.IdentityMap;
import onlinerealestateproject.util.ToolDelete;
import onlinerealestateproject.util.ToolFind;
import onlinerealestateproject.util.ToolInsert;
import onlinerealestateproject.util.ToolUpdate;
/**
 * @author Junjie Huang
 * 
 */
public class AdministratorMapperImpl implements AdministratorMapper {

	Administrator administrator = new Administrator(0, null, null, null, null, 0, null);
	IdentityMap<Administrator> map = IdentityMap.getInstance(administrator);
	
	@Override
	public boolean isFind(String username, String password) {
		// TODO Auto-generated method stub
		ToolFind tf = new ToolFind();
		if(tf.findAdmByAccount(username, password))
			return true;
		return false;
	}
	
	@Override
	public Administrator find(int id) {
		// TODO Auto-generated method stub
		ToolFind tf = new ToolFind();
		map.put(id, tf.findAdmin(id));
		return map.get(id);
		


	}

	@Override
	public boolean insert(Administrator administrator) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolInsert ti = new ToolInsert();
		if(ti.insertUAC(administrator.uid, administrator.firstName, administrator.lastName, 
				administrator.userName, administrator.password, administrator.order, administrator.permission, "administrator")){
			map.put(administrator.getUid(),administrator);
			return true;
		}
		return false;
		
	}

	@Override
	public boolean update(Administrator administrator) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolUpdate tu = new ToolUpdate();
		if(map.get(administrator.getUid())!=null){
			map.put(administrator.getUid(), administrator);
		
			if(tu.updateUAC(administrator.uid, administrator.firstName, administrator.lastName,
				administrator.userName, administrator.password,administrator.order, administrator.permission, "administrator"))
				return true;
			return false;
		}
		return false;
	}


	@Override
	public boolean delete(Administrator administrator) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolDelete td = new ToolDelete();
		if(map.get(administrator.getUid())!=null){
			map.put(administrator.getUid(), null);
			if(td.delete(administrator.getUid(), "administator"))
			return true;
		return false;
	}
	
	return false;
}

}
