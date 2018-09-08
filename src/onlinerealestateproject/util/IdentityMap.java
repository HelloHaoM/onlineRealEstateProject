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
	user = map.get(1);
	if (user == null) {
		//read record from the database
		User user1 = new User(0, "harry", "potter", "harry", "123", 0, "clinet");
		UserMapperImpl umi = new UserMapperImpl();
		user1.setUid(umi.find(1, "user").getUid());
		user1.setFirstName(umi.find(1, "user").getFirstName());
		user1.setLastName(umi.find(1, "user").getLastName());
		user1.setUserName(umi.find(1, "user").getUserName());
		user1.setPassword(umi.find(1, "user").getPassword());
		user1.setOrder(umi.find(1, "user").getOrder());
		user1.setPermission(umi.find(1, "user").getPermission());
		map.put(1, user1);
		}
	System.out.println("sky fall");
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


