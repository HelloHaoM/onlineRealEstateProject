package onlinerealestateproject.datasource;

import onlinerealestateproject.domain.User;;
/**
 * @author Junjie Huang
 * 
 */
public interface UserMapper {
	public User find(int id, String tablename);
	public boolean insert (User user) throws DataMapperException;
	public boolean update (User user) throws DataMapperException;
	public boolean delete (User user) throws DataMapperException;

}
