package com.fs.util;

import java.util.*;



/**
 * @author lxg
 * 
 * 生成随机字符串
 * 
 * 2015年12月11日下午8:10:43
 */
public class UUIDUtil {
	
	private static String STR = "QWERTYUIOPLKJHGFDSAZXCVBNMgjhiklmnopqrstuvwxyz";
	
	/**
	 * 生成8位随机字符串
	 * @return
	 */
	public static String get8str() {
		String ss = getUUID();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=4; i++){
			char c = ss.charAt((new Random().nextInt(32)));
			sb.append(c);
			sb.append(STR.charAt(new Random().nextInt(45)));
		}
		return sb.toString();
	}

	/**
	 * 生成5位随机字符串
	 * 
	 * @return
	 */
	public static String get5str() {
		String ss = getUUID();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=5; i++){
			char c = ss.charAt((new Random().nextInt(32)));
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		StringBuilder sb = new StringBuilder(s.substring(0,8));
		sb.append(s.substring(9,13));
		sb.append(s.substring(14,18));
		sb.append(s.substring(19,23));
		sb.append(s.substring(24));
		return sb.toString();
	}

}
