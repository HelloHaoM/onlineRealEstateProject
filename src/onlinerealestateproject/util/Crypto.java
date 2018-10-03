package onlinerealestateproject.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

import onlinerealestateproject.controller.SessionManager;

public class Crypto {
	private static Crypto cryptoManager = new Crypto();

	public static Crypto getInstance() {
		if (cryptoManager == null)
			cryptoManager = new Crypto();
		return cryptoManager;
	}
	
//	public static void main(String[] args) {
//		String key = "Bar19346Bcr12345";
//		String initVector = "RandomInitVector"; 
//		String plaintext = "whatever";
//		String cipher = encrypt(key, initVector, plaintext);
//		System.out.println(encrypt(key, initVector, plaintext));
//		System.out.println(decrypt(key, initVector, cipher));
//
//	}

	public static String encrypt(String key, String randomnumber, String value) {
		try {
			IvParameterSpec ips = new IvParameterSpec(randomnumber.getBytes("UTF-8"));
			SecretKeySpec sks = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, sks, ips);

			byte[] encrypted = cipher.doFinal(value.getBytes());

			return Base64.encodeBase64String(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static String decrypt(String key, String randomnumber, String encrypted) {
		try {
			IvParameterSpec ips = new IvParameterSpec(randomnumber.getBytes("UTF-8"));
			SecretKeySpec sks = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, sks, ips);

			byte[] plaintext = cipher.doFinal(Base64.decodeBase64(encrypted));

			return new String(plaintext);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

}