package com.fs.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 短网址生成
 * 
 * @author 李新广
 *
 * 2016年1月8日下午4:17:19
 */
public class DwzUtil {
	
	/**
	 * 根据出入的url，调用百度短网址生成API，返回生成的短网址
	 * @param param
	 * @return
	 */
	public static String getDwz(Map<String,String> param){
		
		String jsonStr = HttpUtil.Post("http://dwz.cn/create.php", param);
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		return jsonObject.getString("tinyurl");
	}
}
