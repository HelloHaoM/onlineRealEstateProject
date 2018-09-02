package onlinerealestateproject.datasource;

import java.awt.List;

import onlinerealestateproject.domain.Client;

public class ClientMapperImpl {
	
	public static List findWithLastName(String lastName) {
		String sql = "SELECT Cid, FirstName, LastName, UserName, Password " +
		      "  from Client " +
		" WHERE lastName = {0}";
		return null;
	}
	
	public static void update(Client client) {
		String sql =
			      "UPDATE Client " +
			      "  set lastname = {0}, firstname = {1}, number_of_dependents = {2}" +
			      "  where id = {3}";
		
	}
	
	
	
}
