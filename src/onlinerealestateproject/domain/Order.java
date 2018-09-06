package onlinerealestateproject.domain;

import java.util.UUID;

/**
 * @author haomai
 * A object of order storing 
 */
public class Order {
	
	private UUID oid;
	private int uid;
	private int apid;
	
	private String orderDate;
	private String inspStartTime;
	private String inspEndTime;
	private int id;
	
	private String inspectionTime;
	
	public Order(UUID oid, int uid, int apid, String orderDate, String inspectionTime) {
		this.oid = oid;
		this.uid = uid;
		this.apid = apid;
		this.orderDate = orderDate;
		this.inspectionTime = inspectionTime;
	}
	
	public Order(int aid1, String inspStartTime, String inspEndTime, int id, int apid2) {
		// TODO Auto-generated constructor stub
		this.uid = aid1;
		this.apid = apid2;
		this.inspStartTime = inspStartTime;
		this.inspEndTime = inspEndTime;
		this.id = id;
		
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private void load() {
		
	}

	public UUID getOid() {
		if(this.oid == null)
			load();
		return this.oid;
	}

	public void setOid(UUID oid) {
		this.oid = oid;
	}

	public int getUid() {
		if(this.uid == -1)
			load();
		return this.uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getApid() {
		if(this.apid == -1)
			load();
		return this.apid;
	}

	public void setApid(int apid) {
		this.apid = apid;
	}

	public String getOrderDate() {
		if(this.orderDate == null)
			load();
		return this.orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getInspectionTime() {
		if(this.inspectionTime == null)
			load();
		return this.inspectionTime;
	}

	public void setInspectionTime(String inspectionTime) {
		this.inspectionTime = inspectionTime;
	}
	
	
	

	
}
