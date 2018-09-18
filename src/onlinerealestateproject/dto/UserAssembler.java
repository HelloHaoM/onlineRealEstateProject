package onlinerealestateproject.dto;

import onlinerealestateproject.datasource.UserMapper;
import onlinerealestateproject.datasource.imp.UserMapperImpl;
import onlinerealestateproject.domain.User;

/**
 * @author haomai
 * An user assembler object
 */

public class UserAssembler {
	
	public static UserDTO writeDTO(User user) {
		UserDTO result = new UserDTO(user.getUid(),
				user.getUserName(), user.getPassword());
		return result;
	}
	
	public static void updateUser(String id, UserDTO dto) {
		UserMapper userMapper = new UserMapperImpl();
		User user  = userMapper.find(Integer.parseInt(id));
		if(user == null)
			throw new RuntimeException("User does not exist: " + dto.getUsername());
		user.setUserName(dto.getUsername());
		user.setPassword(dto.getPassword());
	}
}
