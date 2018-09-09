package onlinerealestateproject.datasource;

import java.util.ArrayList;
import java.util.List;

import onlinerealestateproject.domain.Apartment;

/**
 * @author Junjie Huang
 * 
 */
public interface ApartmentMapper {
	
	// find an apartment by an id
	public Apartment find(int id);
	// find all apartment
	public ArrayList<Apartment> findAllApartments();
	// insert an apartment
	public boolean insert (Apartment apartment) throws DataMapperException;
	// update an apartment
	public boolean update (Apartment apartment) throws DataMapperException;
	// delete an apartment
	public boolean delete (Apartment apartment) throws DataMapperException;
	

}
