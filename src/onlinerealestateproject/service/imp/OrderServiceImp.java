package onlinerealestateproject.service.imp;

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
	
	
	public boolean makeOrder(int uid, int apid, String inspectionTime) {
		Order order = new Order(0, inspectionTime, inspectionTime, uid, apid);
		
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
	
	public boolean updateOrder(int oid, String inspectionTime) {
		OrderMapper orderMapper = new OrderMapperImpl();
		
		if(orderMapper.updateOrderInspectionTime(oid, inspectionTime))
			return true;
		return false;
	}

}
