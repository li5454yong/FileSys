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
	
	@Test
	public void getDwz(){
		Map<String,String> param = new HashMap<String, String>();
		param.put("url", "http://localhost:8080/FileSys/publicShare/a.html");
		String jsonStr = HttpUtil.Post("http://dwz.cn/create.php", param);
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		System.out.println(jsonStr);
		//return "";
	}
}
