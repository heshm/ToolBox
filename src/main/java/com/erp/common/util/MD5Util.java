package com.erp.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	private static final char DIGITS_LOWER[] = { '0', '1', '2', '3', '4', '5','6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	private static final char DIGITS_UPPER[] = { '0', '1', '2', '3', '4', '5','6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	private static final String DEFAULT_ENCODING = "UTF8";
	private static final String ALGORITH = "MD5";
	private static final MessageDigest md = getMessageDigest(ALGORITH);

	
	public static String digest(String srcStr, String encode) {
		byte[] rstBytes;
		try {
			rstBytes = md.digest(srcStr.getBytes(encode));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		return toHex(rstBytes, true);
	}

	
	public static String digest(String srcStr) {
		return digest(srcStr, DEFAULT_ENCODING).toUpperCase();
	}

	
	private static MessageDigest getMessageDigest(String algorithm) {
		try {
			return MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public static String toHex(byte[] bytes, boolean flag) {
		return new String(processBytes2Hex(bytes, flag ? DIGITS_LOWER : DIGITS_UPPER));
	}

	
	private static char[] processBytes2Hex(byte[] bytes, char[] digits) {
		int l = bytes.length << 1;
		char[] rstChars = new char[l];
		int j = 0;
		for (int i = 0; i < bytes.length; i++) {
			
			rstChars[j++] = digits[(0xf0 & bytes[i]) >>> 4];
			
			rstChars[j++] = digits[0x0f & bytes[i]];
		}
		return rstChars;
	}

}
