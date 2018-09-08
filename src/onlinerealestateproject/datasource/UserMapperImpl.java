package onlinerealestateproject.datasource;

import onlinerealestateproject.domain.User;
import onlinerealestateproject.util.ToolDelete;
import onlinerealestateproject.util.ToolFind;
import onlinerealestateproject.util.ToolInsert;
import onlinerealestateproject.util.ToolUpdate;
/**
 * @author Junjie Huang
 * 
 */
public class UserMapperImpl implements UserMapper {

	@Override
	public User find(int id, String tablename) {
		// TODO Auto-generated method stub
		ToolFind tf = new ToolFind();
		return tf.findUser(id);
		
		
	}

	@Override
	public boolean insert(User user) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolInsert ti = new ToolInsert();
		if(ti.insertUAC(user.uid, user.firstName, user.lastName, user.userName, user.password, user.order, user.permission, "user"))
			return true;
		return false;
		
		
	}

	@Override
	public boolean update(User user) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolUpdate tu = new ToolUpdate();
		if(tu.updateUAC(user.uid, user.firstName, user.lastName,
				user.userName, user.password,user.order,user.permission, "user"))
			return true;
		return false;
	
	}

	@Override
	public boolean delete(User user) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolDelete td = new ToolDelete();
		if(td.delete(user.getUid(), "user"))
			return true;
		return false;
	}

}
