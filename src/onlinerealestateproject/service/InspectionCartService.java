/**
 * 
 */
package onlinerealestateproject.service;

import java.util.ArrayList;

import onlinerealestateproject.domain.InspectionCart;
import onlinerealestateproject.domain.Order;

/**
 * @author haomai
 * A inspection cart service interface
 */
public interface InspectionCartService {
	
	public InspectionCart getCartOf(int uid);
	public ArrayList<Order> getAllOrderInCart(int uid);
	public String cleanCart(int uid);

}
