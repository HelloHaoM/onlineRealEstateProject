package onlinerealestateproject.dto;

import onlinerealestateproject.datasource.UserMapper;
import onlinerealestateproject.datasource.imp.UserMapperImpl;
import onlinerealestateproject.domain.User;
import onlinerealestateproject.util.UserFactory;

/**
 * @author haomai
 * An user assembler object
 */

public class UserAssembler {
	
	public static UserDTO writeDTO(User user) {
		UserDTO result = new UserDTO(user.getUid(),
				user.getUserName(), user.getPassword(), user.getPermission());
		return result;
	}
	
	public static void updateUser(int id, UserDTO dto) {
		UserMapper userMapper = new UserMapperImpl();
		User user  = userMapper.find(id);
		if(user == null)
			throw new RuntimeException("User does not exist: " + dto.getUsername());
		user.setUserName(dto.getUsername());
		user.setPassword(dto.getPassword());
	}
	
	public static void createUser(UserDTO dto) {
		User user = UserFactory.createSimpleUser("client", 
				dto.getUsername(), dto.getPassword());
		UserMapper userMapper = new UserMapperImpl();
		userMapper.insert(user);
	}
}
