package onlinerealestateproject.datasource;

import java.util.List;

import onlinerealestateproject.domain.Order;



/**
 * @author Junjie Huang
 * 
 */
public interface OrderMapper {
	
	public Order find(int id);
	public List<Order> findAllOrders(int id);
	public boolean insert (Order order) throws DataMapperException;
	public boolean update (Order order) throws DataMapperException;
	public boolean delete (Order order) throws DataMapperException;


}
