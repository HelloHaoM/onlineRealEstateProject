package onlinerealestateproject.util;

import java.util.HashMap;
import java.util.Map;

import onlinerealestateproject.datasource.UserMapperImpl;
import onlinerealestateproject.domain.User;

public class IdentityMap<E> {
	private Map<Long, E> map = new HashMap<Long, E>();
//	System.out.println("-------- MySQL JDBC Connection Testing ------------");
//	User user = null;
//	//	User user = new User(0, "harry", "potter", "harry", "123", 0, "client");
//	IdentityMap<User> map = IdentityMap.getInstance(user);
////	
//	int id1 = 1;
//	int id2 = 2;
//	user = map.get(id1);
////	System.out.println("1");
//	
//		user.setFirstName(umi.find(id1, "user").getFirstName());
//		user.setLastName(umi.find(id1, "user").getLastName());
//		user.setUserName(umi.find(id1, "user").getUserName());
//		user.setPassword(umi.find(id1, "user").getPassword());
//		user.setOrder(umi.find(id1, "user").getOrder());
//		user.setPermission(umi.find(id1, "user").getPermission());
//		System.out.println(user.getFirstName()+"helllo");
//		map.put(id1, user);
//		System.out.println(map.get(id1));
//  }
  public static void main(String[] argv) {
//
	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	User user = null;
	IdentityMap<User> map = IdentityMap.getInstance(user);
//	
	int id1 = 1;
	int id2 = 2;
//	user = map.get(id1);
//	System.out.println("1");
	if (user == null) {
		//read record from the database
//		User user1 = new User(0, null, null, null, null, 0, null);
		UserMapperImpl umi = new UserMapperImpl();
		System.out.println(umi.find(1, "user").getFirstName());

		
		user.setUid(umi.find(id1, "user").getUid());
		user.setFirstName(umi.find(id1, "user").getFirstName());
		user.setLastName(umi.find(id1, "user").getLastName());
		user.setUserName(umi.find(id1, "user").getUserName());
		user.setPassword(umi.find(id1, "user").getPassword());
		user.setOrder(umi.find(id1, "user").getOrder());
		user.setPermission(umi.find(id1, "user").getPermission());
//		System.out.println("test");
//		System.out.println(user.getUid()+" hello");
//		System.out.println(user.getFirstName()+" hello");
		
	}
//		user.setFirstName(umi.find(id1, "user").getFirstName());
//		user.setLastName(umi.find(id1, "user").getLastName());
//		user.setUserName(umi.find(id1, "user").getUserName());
//		user.setPassword(umi.find(id1, "user").getPassword());
//		user.setOrder(umi.find(id1, "user").getOrder());
//		user.setPermission(umi.find(id1, "user").getPermission());
		System.out.println(user.getFirstName()+"helllo");
		map.put(id1, user);
		System.out.println(map.get(id1));
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


