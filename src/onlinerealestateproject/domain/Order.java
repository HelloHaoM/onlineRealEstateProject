package onlinerealestateproject.domain;

import java.util.UUID;

/**
 * @author haomai
 * A object of order storing 
 */
public class Order {
	
	
	public int oid;
	public int apid;
	
	
	public String inspStartTime;
	public String inspEndTime;
	public int uid;
	

	
	
	public Order(int oid, String inspStartTime, String inspEndTime, int uid, int apid2) {
		// TODO Auto-generated constructor stub
		this.oid = oid;
		this.apid = apid2;
		this.inspStartTime = inspStartTime;
		this.inspEndTime = inspEndTime;
		this.uid = uid;
		
	}




	public int getOid() {
		return oid;
	}




	public void setOid(int oid) {
		this.oid = oid;
	}




	public int getApid() {
		return apid;
	}




	public void setApid(int apid) {
		this.apid = apid;
	}




	public String getInspStartTime() {
		return inspStartTime;
	}




	public void setInspStartTime(String inspStartTime) {
		this.inspStartTime = inspStartTime;
	}




	public String getInspEndTime() {
		return inspEndTime;
	}




	public void setInspEndTime(String inspEndTime) {
		this.inspEndTime = inspEndTime;
	}




	public int getUid() {
		return uid;
	}




	public void setUid(int uid) {
		this.uid = uid;
	}

	
	

	
}
