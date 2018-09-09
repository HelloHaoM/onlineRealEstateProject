package onlinerealestateproject.datasource;

import java.util.ArrayList;
import java.util.List;

import onlinerealestateproject.domain.Order;



/**
 * @author Junjie Huang
 * 
 */
public interface OrderMapper {
	
	// find a order by an id
	public Order find(int id);
	// find all orders
	public ArrayList<Order> findAllOrders(int id);
	// insert an order
	public boolean insert (Order order) throws DataMapperException;
	// update an order
	public boolean update (Order order) throws DataMapperException;
	// update order's inspection time
	public boolean updateOrderInspectionTime (int oid, String inspectionTime) throws DataMapperException;
	// delete an order
	public boolean delete (Order order) throws DataMapperException;
	// delete an order by oid
	public boolean delete (int oid) throws DataMapperException;


}
