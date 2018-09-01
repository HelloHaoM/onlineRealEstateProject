package onlinerealestateproject.datasource;

import java.awt.List;

public class ClientMapper {
	
	public static List findWithLastName(String lastName) {
		String sql = "SELECT Cid, FirstName, LastName, UserName, Password " +
		      "  from Client " +
		" WHERE lastName = {0}";
		return null;
	}
}
