package onlinerealestateproject.datasource;

import java.util.ArrayList;
import java.util.List;

import onlinerealestateproject.domain.Order;



/**
 * @author Junjie Huang
 * 
 */
public interface OrderMapper {
	
	public Order find(int id);
	public ArrayList<Order> findAllOrders(int id);
	public boolean insert (Order order) throws DataMapperException;
	public boolean update (Order order) throws DataMapperException;
	public boolean updateOrderInspectionTime (int oid, String inspectionTime) throws DataMapperException;
	public boolean delete (Order order) throws DataMapperException;
	public boolean delete (int oid) throws DataMapperException;


}
