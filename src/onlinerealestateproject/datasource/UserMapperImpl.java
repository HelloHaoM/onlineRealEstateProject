package onlinerealestateproject.datasource;

import Util.ToolDelete;
import Util.ToolFind;
import Util.ToolInsert;
import Util.ToolUpdate;
import onlinerealestateproject.domain.User;
/**
 * @author Junjie Huang
 * 
 */
public class UserMapperImpl implements UserMapper {

	@Override
	public User find(String statement, String tablename) {
		// TODO Auto-generated method stub
		ToolFind tf = new ToolFind();
		return tf.findUser("");
		
		
	}

	@Override
	public void insert(User user) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolInsert ti = new ToolInsert();
		ti.insertUAC(user.uid, user.firstName, user.lastName, user.userName, user.password, user.order, user.permission, "user");
		
		
	}

	@Override
	public void update(User user) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolUpdate tu = new ToolUpdate();
		tu.updateUAC(user.uid, user.firstName, user.lastName,
				user.userName, user.password,user.order,user.permission, "user");
	
	}

	@Override
	public void delete(User user) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolDelete td = new ToolDelete();
		td.delete(1, "user");
	}

}
