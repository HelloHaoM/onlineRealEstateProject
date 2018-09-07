package onlinerealestateproject.domain;


import onlinerealestateproject.datasource.ClientMapperImpl;
import onlinerealestateproject.datasource.DataMapperException;

/**
 * @author haomai
 * A client object extends User object
 */
public class Client extends User{
	
	private InspectionCart cart;

	public Client(int cid, String firstName, String lastName, 
			String userName, String password, int order, 
			String permission, InspectionCart cart) {
		super(cid, firstName, lastName, userName, password, order, permission);
		this.cart = cart;
	}
	
	public Client(int cid, String firstName, String lastName, 
			String userName, String password, int order, 
			String permission) {
		super(cid,firstName,lastName,userName,password,order,permission);
	}

	public Client find(int id) {
		
		ClientMapperImpl clientMapperImpl = new ClientMapperImpl();
		return clientMapperImpl.find(id);
		
	}
	
	
	public void insert (Client client) throws DataMapperException{
		
		ClientMapperImpl clientMapperImpl = new ClientMapperImpl();
		clientMapperImpl.insert(client);;
	}
	
	
	public void update (Client client) throws DataMapperException{
		
		ClientMapperImpl clientMapperImpl = new ClientMapperImpl();
		clientMapperImpl.update(client);;
	}
	
	
	public void delete (Client client) throws DataMapperException{
		
		ClientMapperImpl clientMapperImpl = new ClientMapperImpl();
		clientMapperImpl.delete(client);;
	}
	
}
