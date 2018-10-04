package onlinerealestateproject.datasource;

import java.util.ArrayList;

import onlinerealestateproject.domain.Apartment;

public interface ApartmentLockMapper {

	// find an apartment by an id
	public Apartment find(int id);

	// find all apartment
	public ArrayList<Apartment> findAllApartments();

	public boolean insert(Apartment apartment)throws DataMapperException;

	public boolean update(Apartment apartment) throws DataMapperException;

	public boolean delete(Apartment apartment)throws DataMapperException;
	
	public boolean delete(int apid) throws DataMapperException;
	
	
}
