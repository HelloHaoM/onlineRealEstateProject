package onlinerealestateproject.util;

import java.util.ArrayList;
import java.util.List;

import onlinerealestateproject.datasource.imp.AdministratorMapperImpl;
import onlinerealestateproject.datasource.imp.ClientMapperImpl;
import onlinerealestateproject.datasource.imp.UserMapperImpl;
import onlinerealestateproject.domain.*;

/**
 * @author Junjie Huang
 * 
 */
	public class UnitofWorkU {
		private static ThreadLocal current = new ThreadLocal();
//		public class DomainObject<T> {
//			
//		}
		List<User> newObjects = new ArrayList<>();
		private List<User> dirtyObjects = new ArrayList<>(); 
		private List<User> deletedObjects = new ArrayList<>();
		
		public static void newCurrent() 
		{ 
			setCurrent(new UnitofWorkU());
		}
		public static void setCurrent(UnitofWorkU uow) 
		{ current.set(uow);
		}
		public static UnitofWorkU getCurrent() { 
			return (UnitofWorkU) current.get();
		}
		public void registerNew(User obj) { 

			newObjects.add(obj);
		}
	
		public void registerDirty(User obj) {
			assertNotNull(obj);
			Assert.notNull(obj.getUid(), "id is null");
			Assert.isTrue(!deletedObjects.contains(obj), "object is deleted"); 
			if (!dirtyObjects.contains(obj) && !newObjects.contains(obj)) {
				dirtyObjects.add(obj);
			}
	    	}
		public void registerDeleted(User obj) 
			{ 
//			Assert.notNull(obj.getId(), "id is null");
	    	if (newObjects.remove(obj)) return; dirtyObjects.remove(obj);
	    	if (!deletedObjects.contains(obj)) { deletedObjects.add(obj);
	    	} }
		
//		public void registerClean(User obj) { 
//			Assert.notNull(obj.getId(), "id is null");
//	    
//		}
	
	
		public void commit(String objectClass) {

			for (User obj : newObjects) {
				UserMapperImpl umi =new UserMapperImpl();
				umi.insert(obj);
			}
			for (User obj : dirtyObjects) { 
				UserMapperImpl umi =new UserMapperImpl();
				umi.update(obj);
			}
			for (User obj : deletedObjects) {
				UserMapperImpl umi =new UserMapperImpl();
				umi.delete(obj);
			}

		}

	}
