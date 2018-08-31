package onlinerealestateproject.service;

import onlinerealestateproject.domain.Order;

/**
 * @author haomai
 * A order service interface 
 */

public interface OrderService {
	
	public String makeOrder(int uid, Order order);
	public String deleteOrder(int uid, Order order);

}
