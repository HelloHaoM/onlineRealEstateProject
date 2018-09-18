package onlinerealestateproject.lock;

public interface LockManager {
	
	public boolean acquireLock(long lockable, String owner);
	public void releaseLock(long lockable, String owner);
	public void releaseAllLocks(String owner);

}
