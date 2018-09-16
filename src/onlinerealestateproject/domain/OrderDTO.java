package onlinerealestateproject.domain;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.InputStream;
import java.io.OutputStream;

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
