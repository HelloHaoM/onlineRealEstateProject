package onlinerealestateproject.service;

import onlinerealestateproject.domain.Order;

/**
 * @author haomai
 * A order service interface 
 */

public interface OrderService {
	
	public boolean makeOrder(int uid, int apid, String inspectionTime);
	public boolean deleteOrder(int uid, int oid);
	public boolean updateOrder(int oid, String inspectionTime);

}
