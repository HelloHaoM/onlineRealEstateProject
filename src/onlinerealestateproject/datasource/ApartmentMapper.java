package onlinerealestateproject.datasource;

import java.util.ArrayList;
import java.util.List;

import onlinerealestateproject.domain.Apartment;

/**
 * @author Junjie Huang
 * 
 */
public interface ApartmentMapper {
	public Apartment find(int id);
<<<<<<< HEAD
	public List<Apartment> findAllApartments();
=======
	public ArrayList<Apartment> findAllApartments();
>>>>>>> d6bfa2a7b5bdcaf4cb302bdb8aca852c25413498
	public boolean insert (Apartment apartment) throws DataMapperException;
	public boolean update (Apartment apartment) throws DataMapperException;
	public boolean delete (Apartment apartment) throws DataMapperException;
	

}
