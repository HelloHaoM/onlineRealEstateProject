package onlinerealestateproject.dto;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.xml.bind.Element;

/**
 * @author haomai
 * An user dto object
 */

public class UserDTO implements Serializable{
	
	private int uid;
	private String username;
	private String password;
	private String permission;

	
	public UserDTO(int uid, String username, String password, String permission) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.permission = permission;
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
	
	
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public static void toXML(UserDTO userDTO, OutputStream outputStream) {
		XMLEncoder encoder = new XMLEncoder(outputStream);
		encoder.writeObject(userDTO);
		encoder.close();
	}
	
	public static UserDTO fromXML(InputStream inputStream) {
		XMLDecoder decoder = new XMLDecoder(inputStream);
		UserDTO result = (UserDTO) decoder.readObject();
		return result;
	}
	
	public static byte[] object2Byte(UserDTO userDTO) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(userDTO);
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
	
	public static UserDTO byte2Object(byte[] userByte) {
		ByteArrayInputStream in = new ByteArrayInputStream(userByte);
		try {
			ObjectInputStream oin = new ObjectInputStream(in);
			UserDTO result = (UserDTO)oin.readObject();
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
