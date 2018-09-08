package onlinerealestateproject.util;

import java.util.HashMap;
import java.util.Map;

import onlinerealestateproject.datasource.UserMapperImpl;
import onlinerealestateproject.domain.User;

public class IdentityMap<E> {
	private Map<Long, E> map = new HashMap<Long, E>();
  public static void main(String[] argv) {

	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	User user = new User(0, "harry", "potter", "harry", "123", 0, "clinet");
	IdentityMap<User> map = IdentityMap.getInstance(user);
	user = map.get(2);
	int id = 2;
	int id2 = 1;
	
	if (user == null) {
		//read record from the database
//		User user1 = new User(0, null, null, null, null, 0, null);
		UserMapperImpl umi = new UserMapperImpl();
		user.setUid(umi.find(id, "user").getUid());
		user.setFirstName(umi.find(id, "user").getFirstName());
		user.setLastName(umi.find(id, "user").getLastName());
		user.setUserName(umi.find(id, "user").getUserName());
		user.setPassword(umi.find(id, "user").getPassword());
		user.setOrder(umi.find(id, "user").getOrder());
		user.setPermission(umi.find(id, "user").getPermission());
		map.put(id2, user);
		}
	System.out.println("sky fall");
//	System.out.println(map.get(1));
	System.out.println(user);
	
	
	
  }
	
	private static Map<Class, IdentityMap> singletons = new HashMap<Class, IdentityMap>();
	
	public static <E> IdentityMap<E> getInstance(E e) 
	{
		IdentityMap<E> result = singletons.get(e.getClass()); 
		
		if (result == null) {
			
			result = new IdentityMap<E>();

			singletons.put(e.getClass(), result);
		  }
		return result; 
		}
	
		public void put(long id, E obj){ 
			map.put(id, obj);
		}
		
		public E get(long id) 
		{ 
			return map.get(id);
		} 
	}


