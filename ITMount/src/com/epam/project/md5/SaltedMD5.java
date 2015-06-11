package com.epam.project.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SaltedMD5 {

	 public static String getPassword(String passwordToHash, String salt)
	    {
	        String generatedPassword = null;
	        try {
	          
	            MessageDigest md = MessageDigest.getInstance("MD5");
	           
	            md.update(salt.getBytes());
	            
	            byte[] bytes = md.digest(passwordToHash.getBytes());
	           
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            
	            generatedPassword = sb.toString();
	        }
	        catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return generatedPassword;
	    }
}
