package onlinerealestateproject.datasource;

import java.sql.SQLException;
/**
 * @author Junjie Huang
 * 
 */
public final class DataMapperException extends RuntimeException{
	public DataMapperException (final SQLException e) {
		super(e);
	}
	

}
