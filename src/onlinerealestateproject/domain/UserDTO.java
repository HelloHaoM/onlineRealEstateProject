package onlinerealestateproject.domain;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.Element;

public class UserDTO {
	
	private int uid;
	private String username;
	private String password;
	
	public UserDTO(int uid, String username, String password) {
		this.uid = uid;
		this.username = username;
		this.password = password;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static void toXML(UserDTO userDTO, OutputStream outputStream) {
		XMLEncoder encoder = new XMLEncoder(outputStream);
		encoder.writeObject(userDTO);
		encoder.close();
	}
	
	public UserDTO fromXML(InputStream inputStream) {
		XMLDecoder decoder = new XMLDecoder(inputStream);
		UserDTO result = (UserDTO) decoder.readObject();
		return result;
	}
}
