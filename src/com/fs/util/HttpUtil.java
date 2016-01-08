package com.fs.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpUtil {
	
	//@Test
	public void demo(){
		Map<String,String> params = new HashMap<String, String>();
		params.put("mobile","123456");
		//HttpUtil.Post("http://172.17.1.224:8080/RongYi-Pay/testAjax", params, "UTF-8");
	}
	
	public static String Post(String url, Map<String, String> params) {
		StringBuffer response = new StringBuffer();
		HttpClient client = new HttpClient();

		PostMethod post = new PostMethod(url);
		post.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=utf-8");

		HttpMethod method = null;
		
		String result = "";
		// 设置Http Post数据
		if (params != null) {
			NameValuePair[] param = new NameValuePair[params.size()];
			HttpMethodParams p = new HttpMethodParams();
			
			int i = 0;
			for (Map.Entry<String, String> entry : params.entrySet()) {
				param[i] = new NameValuePair(entry.getKey(),entry.getValue());
				i++;
			}

			post.setRequestBody(param);
			method = post;
			
		}
		try {
			int status = client.executeMethod(method);
			if(200 == status){
				result = method.getResponseBodyAsString();
			}
		} catch (IOException e) {
			result = null;
		} 
		
		return result;
		
	}
}
