package onlinerealestateproject.lock;

import onlinerealestateproject.lock.impl.ExclusiveWriteLockManager;

public interface LockManager {
	
	
	public boolean acquireLock(int lockable, String owner);
	public void releaseLock(int lockable, String owner);
	public void releaseAllLock(String owner);
	
}
