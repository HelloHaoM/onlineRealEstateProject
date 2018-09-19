package onlinerealestateproject.dto;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * @author haomai
 * An order dto object
 */

public class OrderDTO implements Serializable{
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
	
	public static byte[] object2Byte(OrderDTO orderDTO) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(orderDTO);
			byte[] result = out.toByteArray();
			out.close();
			oos.close();
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static OrderDTO byte2Object(byte[] orderByte) {
		ByteArrayInputStream in = new ByteArrayInputStream(orderByte);
		try {
			ObjectInputStream oin = new ObjectInputStream(in);
			OrderDTO result = (OrderDTO)oin.readObject();
			in.close();
			oin.close();
			return result;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
