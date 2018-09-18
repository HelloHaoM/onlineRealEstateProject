package onlinerealestateproject.lock.impl;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.omg.CORBA.SystemException;

import onlinerealestateproject.lock.LockManager;
import onlinerealestateproject.util.MySQLConnection;
import onlinerealestateproject.util.ToolFind;

public class ExclusiveWriteLockManager implements LockManager{

  public static void main(String[] argv) {

	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	ExclusiveWriteLockManager E = new ExclusiveWriteLockManager();
//	E.acquireLock(3,"heyy");
	E.releaseLock(3, "heyy");
  }
	
	@Override
	public boolean acquireLock(int lockableid, String owner)  {
		// TODO Auto-generated method stub
		boolean result = true;
		if(!hasLock(lockableid,owner)) {
			try {
				System.out.println("2222");
				String sql = "insert into lock (lockableid,owner) values (?,?)";
				MySQLConnection.getSingleMySQLConnection().establishDBConnection();
				PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(sql);
				dbStatement.setInt(1, lockableid);
				dbStatement.setString(2, owner);
				dbStatement.executeUpdate();
				MySQLConnection.getSingleMySQLConnection().closeConnection();
				
			}catch (SQLException e) {
				 
				e.printStackTrace();
				return false;
			}
			
			
		}
		
		return false;
	}

	@Override
	public void releaseLock(int lockableid, String owner) {
		// TODO Auto-generated method stub
		try {
			System.out.println("2222");
			String sql = "delete from lock where lockableid =?";
			System.out.println("2222");
			MySQLConnection.getSingleMySQLConnection().establishDBConnection();
			PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(sql);
			dbStatement.setInt(1, lockableid);
			dbStatement.executeUpdate();
			MySQLConnection.getSingleMySQLConnection().closeConnection();
			
		}catch (SQLException e) {
			e.printStackTrace();

		}
		
		
	}

	public boolean hasLock(int lockableid, String owner) {
		ToolFind tf = new ToolFind();
		return tf.hasLock(lockableid, owner);
		
	}
	
}
