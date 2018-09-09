package onlinerealestateproject.datasource;

import onlinerealestateproject.domain.User;;
/**
 * @author Junjie Huang
 * 
 */
public interface UserMapper {
	// find a user by id 
	public User find(int id, String tablename);
	// insert a user
	public boolean insert (User user) throws DataMapperException;
	// update a user
	public boolean update (User user) throws DataMapperException;
	// delete a user
	public boolean delete (User user) throws DataMapperException;

}
