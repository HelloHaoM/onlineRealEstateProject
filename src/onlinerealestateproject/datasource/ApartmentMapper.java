package onlinerealestateproject.datasource;

import java.util.List;

import onlinerealestateproject.domain.Apartment;

/**
 * @author Junjie Huang
 * 
 */
public interface ApartmentMapper {
	public Apartment find(int id);
	public List<Apartment> findAllApartments(int id);
	public void insert (Apartment apartment) throws DataMapperException;
	public void update (Apartment apartment) throws DataMapperException;
	public void delete (Apartment apartment) throws DataMapperException;
	

}
