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

	public ArrayList<Apartment> findAllApartments();
	public boolean insert (Apartment apartment) throws DataMapperException;
	public boolean update (Apartment apartment) throws DataMapperException;
	public boolean delete (Apartment apartment) throws DataMapperException;
	

}
