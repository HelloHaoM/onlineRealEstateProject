package onlinerealestateproject.dto;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author haomai
 * An order dto object
 */

public class OrderDTO {
	public int uid;
	public int oid;
	public int apid;
	
	public String inspStartTime;
	public String inspEndTime;
	
	public OrderDTO(int uid, int oid, int apid, String inspStartTime, String inspEndTime) {
		this.uid = uid;
		this.oid = oid;
		this.apid = apid;
		this.inspStartTime = inspStartTime;
		this.inspEndTime = inspEndTime;
	}
	
	
	
	public int getUid() {
		return uid;
	}



	public void setUid(int uid) {
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



	public static void toXML(OrderDTO orderDTO, OutputStream outputStream) {
		XMLEncoder encoder = new XMLEncoder(outputStream);
		encoder.writeObject(orderDTO);
		encoder.close();
	}
	
	public static OrderDTO fromXML(InputStream inputStream) {
		XMLDecoder decoder = new XMLDecoder(inputStream);
		OrderDTO result = (OrderDTO) decoder.readObject();
		decoder.close();
		return result;
	}
}
