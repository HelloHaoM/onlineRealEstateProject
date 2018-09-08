package onlinerealestateproject.datasource.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import onlinerealestateproject.datasource.DataMapperException;
import onlinerealestateproject.datasource.MySQLConnection;
import onlinerealestateproject.datasource.OrderMapper;
import onlinerealestateproject.domain.Apartment;
import onlinerealestateproject.domain.Order;
import onlinerealestateproject.util.ToolDelete;
import onlinerealestateproject.util.ToolFind;
import onlinerealestateproject.util.ToolInsert;
import onlinerealestateproject.util.ToolUpdate;

/**
 * @author Junjie Huang
 * 
 */
public class OrderMapperImpl implements OrderMapper{

	@Override
	public ArrayList<Order> findAllOrders(int uid1) {
		// TODO Auto-generated method stub
		ArrayList<Order> orders = new ArrayList<>();
		try {
			String statement = "select * from inspection_order where id="+uid1;
			MySQLConnection mysqlconnection = new MySQLConnection();
			mysqlconnection.getDBConnection();
			mysqlconnection.prepare(statement);
			ResultSet rs = mysqlconnection.prepare(statement).executeQuery();
			 
			while(rs.next()) {
				int oid = rs.getInt(1);
				String inspStartTime = rs.getString(2);
				String inspEndTime = rs.getString(3);
				int id = rs.getInt(4);				
				int apid = rs.getInt(5);								
				Order order = new Order(oid, inspStartTime, 
						inspEndTime,id,apid);
				order.setOid(oid);
				order.setInspStartTime(inspStartTime);
				order.setInspEndTime(inspEndTime);
				order.setUid(id);
				order.setApid(apid);
				orders.add(order);
				
			}	
			
		}catch (SQLException e) {
			
			throw new DataMapperException(e);
		}
		System.out.println(orders.size());
		System.out.println("olala");
		return orders;
		
	}
	
	@Override
	public boolean insert(Order order) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolInsert ti = new ToolInsert();
		if(ti.insertOrder(order.oid,order.inspStartTime,order.inspEndTime,order.uid,order.apid))
			return true;
		return false;
		
		
	}

	@Override
	public boolean update(Order order) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolUpdate tu = new ToolUpdate();
		if(tu.updateOrder(order.oid,order.inspStartTime,order.inspEndTime,order.uid,order.apid))
			return true;
		return false;
	}
	
	@Override
	public boolean updateOrderInspectionTime(int oid, String inspectionTime) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolUpdate tu = new ToolUpdate();
		if(tu.updateOrderInspectionTime(oid, inspectionTime))
			return true;

		return false;
	}

	@Override
	public boolean delete(Order order) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolDelete td = new ToolDelete();
		if(td.deleteOrder(order.getOid(), "inspection_order"))
			return true;
		return false;
		
	}
	
	public boolean delete(int oid) throws DataMapperException {
		// TODO Auto-generated method stub
		ToolDelete td = new ToolDelete();
		if(td.deleteOrder(oid, "order_has_admin"))
			if(td.deleteOrder(oid, "inspection_order"))
				return true;
		return false;
		
	}

	@Override
	public Order find(int id) {
		// TODO Auto-generated method stub
		ToolFind tf = new ToolFind();
		return tf.findOrder(id);
	}



}
