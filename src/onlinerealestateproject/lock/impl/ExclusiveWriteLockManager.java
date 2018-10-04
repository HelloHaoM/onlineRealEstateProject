package onlinerealestateproject.lock.impl;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.omg.CORBA.SystemException;

import onlinerealestateproject.controller.SessionManager;
import onlinerealestateproject.lock.LockManager;
import onlinerealestateproject.util.MySQLConnection;
import onlinerealestateproject.util.ToolFind;

public class ExclusiveWriteLockManager implements LockManager{
	private static ExclusiveWriteLockManager singletonExclusiveWriteLockManager = new ExclusiveWriteLockManager();


	public static ExclusiveWriteLockManager getInstance() {
		if(singletonExclusiveWriteLockManager == null)
			singletonExclusiveWriteLockManager = new ExclusiveWriteLockManager();
		return singletonExclusiveWriteLockManager;
	}
	
	
	@Override
	public boolean acquireLock(int lockableid, String owner)  {
		// TODO Auto-generated method stub
		boolean result = true;
		if(!beenLocked(lockableid,owner)) {
			try {
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
		}else {
			System.out.println("The resource has been locked");
		}
		
		return result;
	}
	
	public boolean acquireLockAp(int apid,String inspstarttime, String owner)  {
		// TODO Auto-generated method stub
		boolean result = true;
		if(!beenLockedAp(apid,inspstarttime,owner)) {
			try {
				String sql = "insert into lockap (apid,inspectstarttime,owner) values (?,?,?)";
				MySQLConnection.getSingleMySQLConnection().establishDBConnection();
				PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(sql);
				dbStatement.setInt(1, apid);
				dbStatement.setString(2, inspstarttime);
				dbStatement.setString(3, owner);
				dbStatement.executeUpdate();
				MySQLConnection.getSingleMySQLConnection().closeConnection();
				
			}catch (SQLException e) {
				 
				e.printStackTrace();
				return false;
			}
		}else {
			System.out.println("The resource has been locked");
		}
		
		return result;
	}

	@Override
	public void releaseLock(int lockableid, String owner) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from lock where lockableid =?";
			MySQLConnection.getSingleMySQLConnection().establishDBConnection();
			PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(sql);
			dbStatement.setInt(1, lockableid);
			dbStatement.executeUpdate();
			MySQLConnection.getSingleMySQLConnection().closeConnection();
			
		}catch (SQLException e) {
			e.printStackTrace();

		}
		
		
	}
	public void releaseLockAp(int apid, String inspectstarttime, String owner) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from lockap where apid =? and inspectstarttime = '"+inspectstarttime+"'";
			MySQLConnection.getSingleMySQLConnection().establishDBConnection();
			PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(sql);
			dbStatement.setInt(1, apid);
			dbStatement.executeUpdate();
			MySQLConnection.getSingleMySQLConnection().closeConnection();
			
		}catch (SQLException e) {
			e.printStackTrace();

		}
		
		
	}
	
	@Override
	public void releaseAllLock(String owner) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from lock where owner=?";
			MySQLConnection.getSingleMySQLConnection().establishDBConnection();
			PreparedStatement dbStatement = MySQLConnection.getSingleMySQLConnection().getConnection().prepareStatement(sql);
			dbStatement.setString(1, owner);
			dbStatement.executeUpdate();
			MySQLConnection.getSingleMySQLConnection().closeConnection();
			
		}catch (SQLException e) {
			e.printStackTrace();

		}
		
	}
	

	public boolean hasLock(int lockableid, String owner) {
		//Judege whether a user has the lock.
		
		ToolFind tf = new ToolFind();
		return tf.hasLock(lockableid, owner);
		
	}
	
	public boolean beenLocked(int lockableid, String owner) {
		//Judege whether the resource has been locked.
		ToolFind tf = new ToolFind();
		return tf.beenLocked(lockableid, owner);
		
	}
	public boolean beenLockedAp(int apid,String inspstarttime, String owner) {
		//Judege whether the resource has been locked.
		ToolFind tf = new ToolFind();
		return tf.beenLockedAp(apid,inspstarttime, owner);
		
	}
	
	
	
}
