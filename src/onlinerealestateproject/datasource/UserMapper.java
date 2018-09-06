package onlinerealestateproject.datasource;

import onlinerealestateproject.domain.User;;
/**
 * @author Junjie Huang
 * 
 */
public interface UserMapper {
	public User find(String statement, String tablename);
	public void insert (User user) throws DataMapperException;
	public void update (User user) throws DataMapperException;
	public void delete (User user) throws DataMapperException;

}
