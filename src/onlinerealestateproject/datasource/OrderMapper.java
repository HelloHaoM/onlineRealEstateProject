package onlinerealestateproject.datasource;

import onlinerealestateproject.domain.Order;


/**
 * @author Junjie Huang
 * 
 */
public interface OrderMapper {
	
	public Order find(String statement, String tablename);
	public void insert (Order order) throws DataMapperException;
	public void update (Order order) throws DataMapperException;
	public void delete (Order order) throws DataMapperException;


}
