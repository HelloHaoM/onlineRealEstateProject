package onlinerealestateproject.datasource;

import Util.ToolDelete;
import Util.ToolFind;
import Util.ToolInsert;
import Util.ToolUpdate;
import onlinerealestateproject.domain.Order;

/**
 * @author Junjie Huang
 * 
 */
public class OrderMapperImpl implements OrderMapper{

	@Override
	public Order find(String statement, String tablename) {
		// TODO Auto-generated method stub
		ToolFind tf = new ToolFind();
		return tf.findOrder("");
		
	}
	
	@Override
	public void insert(Order order) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolInsert ti = new ToolInsert();
		ti.insertOrder(order.oid,order.inspStartTime,order.inspEndTime,order.uid,order.apid);
		
		
	}

	@Override
	public void update(Order order) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolUpdate tu = new ToolUpdate();
		tu.updateOrder(order.oid,order.inspStartTime,order.inspEndTime,order.uid,order.apid);
		
	}

	@Override
	public void delete(Order order) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolDelete td = new ToolDelete();
		td.delete(1, "order");
		
	}


}
