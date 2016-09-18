package in.xgen.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {

	public static String generateHash(String password){
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(password.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length;   idx++) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}

		return hash.toString();
	}
	
	public static String generateHash(String userName,String emailId){
		MessageDigest sha = null;
		byte[] userNamehashedBytes = null;
		byte[] emailIdhashedBytes = null;
		StringBuilder hash = null;		
		try {
			 sha = MessageDigest.getInstance("SHA-1");
			 userNamehashedBytes = sha.digest(userName.getBytes());
			 emailIdhashedBytes = sha.digest(emailId.getBytes());
			 char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
						'a', 'b', 'c', 'd', 'e', 'f' };
			
			 for (int idx = 0; idx < userNamehashedBytes.length;   idx++) {
					byte b = userNamehashedBytes[idx];
					hash.append(digits[(b & 0xf0) >> 4]);
					hash.append(digits[b & 0x0f]);
				}
			 
			 for (int idx = 0; idx < emailIdhashedBytes.length;   idx++) {
					byte b = emailIdhashedBytes[idx];
					hash.append(digits[(b & 0xf0) >> 4]);
					hash.append(digits[b & 0x0f]);
				}
			 
			 
					 
		} catch (NoSuchAlgorithmException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hash.toString();
	}
}
