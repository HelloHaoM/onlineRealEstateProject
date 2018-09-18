package onlinerealestateproject.lock.impl;


import onlinerealestateproject.lock.LockManager;

public class ExclusiveWriteLockManager implements LockManager{

	
	@Override
	public boolean acquireLock(long lockable, String owner)  {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void releaseLock(long lockable, String owner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void releaseAllLocks(String owner) {
		// TODO Auto-generated method stub
		
	}

}
