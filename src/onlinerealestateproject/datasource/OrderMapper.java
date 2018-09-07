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
	public void insert (Order order) throws DataMapperException;
	public void update (Order order) throws DataMapperException;
	public void delete (Order order) throws DataMapperException;


}
