package onlinerealestateproject.util;

import java.util.HashMap;
import java.util.Map;

import onlinerealestateproject.datasource.imp.UserMapperImpl;
import onlinerealestateproject.domain.User;

public class IdentityMap<E> {
	private Map<Long, E> map = new HashMap<Long, E>();

  public static void main(String[] argv) {
	 int id1 = 1;
	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	UserMapperImpl umi = new UserMapperImpl();
	User user = new User(0, null, null, null, null, id1, null);
	user.setUid(umi.find(id1, "user").getUid());
	user.setFirstName(umi.find(id1, "user").getFirstName());
	user.setLastName(umi.find(id1, "user").getLastName());
	user.setUserName(umi.find(id1, "user").getUserName());
	user.setPassword(umi.find(id1, "user").getPassword());
	user.setOrder(umi.find(id1, "user").getOrder());
	user.setPermission(umi.find(id1, "user").getPermission());
	IdentityMap<User> map = IdentityMap.getInstance(user);
	map.put(id1, user);
	
	if(user.getUid() == umi.find(id1, "user").getUid()) {
		System.out.print("ok");
	}else {
		System.out.print("no ok");
	}

	System.out.println(map.get(id1).uid);
	System.out.println(map.get(id1).lastName);
	System.out.println(map.get(id1).userName);
	System.out.println(map.get(id1).password);
	System.out.println(map.get(id1).getOrder());
	System.out.println(map.get(id1).permission);
	
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


