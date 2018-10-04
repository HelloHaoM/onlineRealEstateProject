package onlinerealestateproject.service.imp;

import java.util.ArrayList;

import onlinerealestateproject.datasource.OrderMapper;
import onlinerealestateproject.datasource.imp.OrderMapperImpl;
import onlinerealestateproject.domain.Client;
import onlinerealestateproject.domain.Order;
import onlinerealestateproject.service.OrderService;

/**
 * @author haomai
 * A order service interface implementation
 */

public class OrderServiceImp implements OrderService{
	
	public ArrayList<Order> getAllOrder(int uid){
		OrderMapper orderMapper = new OrderMapperImpl();
		return orderMapper.findAllOrders(uid);
	}
	
	public boolean makeOrder(int uid, int apid, String inspectionTime) {
		// create an new order
		Order order = new Order(0, inspectionTime, inspectionTime, uid, apid);
		
		OrderMapper orderMapper = new OrderMapperImpl();
		// insert into the databse by orderMapper
		if(orderMapper.insert(order))
			return true;
		
		return false;
	}
	
	public boolean deleteOrder(int uid, int oid) {
		OrderMapper orderMapper = new OrderMapperImpl();
		
		// delete the order from the database by an oid
		if(orderMapper.delete(oid)) {
			return true;
		}
		return false;
	}
	
	public boolean updateOrder(int oid, String inspectionTime) {
		OrderMapper orderMapper = new OrderMapperImpl();
		
		// update a specific order
		if(orderMapper.updateOrderInspectionTime(oid, inspectionTime))
			return true;
		return false;
	}

}
