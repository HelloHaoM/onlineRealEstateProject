package onlinerealestateproject.service;

import onlinerealestateproject.datasource.OrderMapper;
import onlinerealestateproject.datasource.OrderMapperImpl;
import onlinerealestateproject.domain.Client;
import onlinerealestateproject.domain.Order;

/**
 * @author haomai
 * A order service interface implementation
 */

public class OrderServiceImp implements OrderService{
	
	
	public boolean makeOrder(int uid, int apid) {
		Order order = new Order(0, "8:00", "8:30", uid, apid);
		
		OrderMapper orderMapper = new OrderMapperImpl();
		if(orderMapper.insert(order))
			return true;
		
		return false;
	}
	
	public boolean deleteOrder(int uid, int oid) {
		OrderMapper orderMapper = new OrderMapperImpl();
		if(orderMapper.delete(oid)) {
			return true;
		}
		return false;
	}

}
