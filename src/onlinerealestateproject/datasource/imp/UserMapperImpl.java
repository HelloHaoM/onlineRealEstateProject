package onlinerealestateproject.datasource.imp;

import onlinerealestateproject.datasource.DataMapperException;
import onlinerealestateproject.datasource.UserMapper;
import onlinerealestateproject.domain.Administrator;
import onlinerealestateproject.domain.User;
import onlinerealestateproject.util.IdentityMap;
import onlinerealestateproject.util.ToolDelete;
import onlinerealestateproject.util.ToolFind;
import onlinerealestateproject.util.ToolInsert;
import onlinerealestateproject.util.ToolUpdate;
/**
 * @author Junjie Huang
 * 
 */
public class UserMapperImpl implements UserMapper {
	User user = new User(0, null, null, null, null, 0, null);
	IdentityMap<User> map = IdentityMap.getInstance(user);

	@Override
	public User find(int id, String tablename) {
		// TODO Auto-generated method stub
		ToolFind tf = new ToolFind();
		map.put(id, tf.findUser(id));
		return map.get(id);
		
		
	}

	@Override
	public boolean insert(User user) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolInsert ti = new ToolInsert();
		if(ti.insertUAC(user.uid, user.firstName, user.lastName, user.userName, user.password, user.order, user.permission, "user"))
		{
			map.put(user.getUid(),user);
			return true;
			}
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
