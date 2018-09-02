package onlinerealestateproject.datasource;

import java.sql.SQLException;

public final class DataMapperException extends RuntimeException{
	public DataMapperException (final SQLException e) {
		super(e);
		
	}
	

}
