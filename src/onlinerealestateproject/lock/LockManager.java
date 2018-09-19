package onlinerealestateproject.lock;

public interface LockManager {
	
	public boolean acquireLock(int lockable, String owner);
	public void releaseLock(int lockable, String owner);
	public void releaseAllLock(String owner);
	
}
