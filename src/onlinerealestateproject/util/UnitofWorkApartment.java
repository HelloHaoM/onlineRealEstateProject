package onlinerealestateproject.util;

import java.util.ArrayList;
import java.util.List;

import onlinerealestateproject.datasource.imp.AdministratorMapperImpl;
import onlinerealestateproject.datasource.imp.ApartmentMapperImpl;
import onlinerealestateproject.datasource.imp.ClientMapperImpl;
import onlinerealestateproject.datasource.imp.OrderMapperImpl;
import onlinerealestateproject.datasource.imp.UserMapperImpl;
import onlinerealestateproject.domain.*;

/**
 * @author Junjie Huang
 * 
 */
	public class UnitofWorkApartment {
		private static ThreadLocal current = new ThreadLocal();
//		public class DomainObject<T> {
//			
//		}
		List<Apartment> newObjects = new ArrayList<>();
		private List<Apartment> dirtyObjects = new ArrayList<>(); 
		private List<Apartment> deletedObjects = new ArrayList<>();
		
		public static void newCurrent() 
		{ 
			setCurrent(new UnitofWorkApartment());
		}
		public static void setCurrent(UnitofWorkApartment uow) 
		{ current.set(uow);
		}
		public static UnitofWorkApartment getCurrent() { 
			return (UnitofWorkApartment) current.get();
		}
		public void registerNew(Apartment obj) { 

			newObjects.add(obj);
		}
	
		public void registerDirty(Apartment obj) {
			
			if (!dirtyObjects.contains(obj) && !newObjects.contains(obj)) {
				dirtyObjects.add(obj);
			}
	    	}
		public void registerDeleted(Apartment obj) 
			{ 
//			Assert.notNull(obj.getId(), "id is null");
	    	if (newObjects.remove(obj)) 
	    		return; 
	    	dirtyObjects.remove(obj);
	    	if (!deletedObjects.contains(obj)) 
	    	{ 
	    		deletedObjects.add(obj);
	    	} 
	    	}
		

	
	
		public void commit() {

			for (Apartment obj : newObjects) {
				ApartmentMapperImpl apmi =new ApartmentMapperImpl();
				apmi.insert(obj);
			}
			for (Apartment obj : dirtyObjects) { 
				ApartmentMapperImpl apmi =new ApartmentMapperImpl();
				apmi.update(obj);
			}
			for (Apartment obj : deletedObjects) {
				ApartmentMapperImpl apmi =new ApartmentMapperImpl();
				apmi.delete(obj);
			}

		}

	}
