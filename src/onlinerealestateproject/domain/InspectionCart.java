package onlinerealestateproject.domain;

import java.util.ArrayList;

/**
 * @author haomai
 * a object of inspection cart storing a user inspection oder
 */
public class InspectionCart {
	
	private ArrayList<Order> orderList;
	
	public InspectionCart() {
		this.orderList = new ArrayList<Order>();
	}
	
	public static InspectionCart getCartOf(int uid) {
		return null;
	}
	
	public void addInspectionOrder(Order order) {
		
	}
	
	public void updateInspectionOrder(int uid, Order order) {
		
	}
	
	public  void deleteInspectionOrder(int uid, Order order) {
		
	}

}
