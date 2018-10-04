package onlinerealestateproject.service;

import java.util.ArrayList;

import onlinerealestateproject.domain.Order;

/**
 * @author haomai
 * A order service interface 
 */

public interface OrderService {
	// find all order of a user
	public ArrayList<Order> getAllOrder(int uid);
	// make an order
	public boolean makeOrder(int uid, int apid, String inspectionTime);
	// delete an order
	public boolean deleteOrder(int uid, int oid);
	// update an order
	public boolean updateOrder(int oid, String inspectionTime);

}
