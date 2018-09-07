package onlinerealestateproject.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.Order;
import onlinerealestateproject.util.ToolDelete;
import onlinerealestateproject.util.ToolFind;
import onlinerealestateproject.util.ToolInsert;
import onlinerealestateproject.util.ToolUpdate;
/**
 * @author Junjie Huang
 * 
 */
public class AdministratorMapperImpl implements AdministratorMapper {

	@Override
	public Administrator find(int id) {
		// TODO Auto-generated method stub
		ToolFind tf = new ToolFind();
		return tf.findAdmin(id);

	}

	@Override
	public void insert(Administrator administrator) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolInsert ti = new ToolInsert();
		ti.insertUAC(administrator.uid, administrator.firstName, administrator.lastName, administrator.userName, administrator.password, administrator.order, administrator.permission, "administrator");
		
	}

	@Override
	public void update(Administrator administrator) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolUpdate tu = new ToolUpdate();
		tu.updateUAC(administrator.uid, administrator.firstName, administrator.lastName,
				administrator.userName, administrator.password,administrator.order, administrator.permission, "administrator");
	}

	@Override
	public void delete(Administrator administrator) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolDelete td = new ToolDelete();
		td.delete(1, "administator");
	}


}
