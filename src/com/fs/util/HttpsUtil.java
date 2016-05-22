package com.fs.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.junit.Test;


public class HttpsUtil {
	
	@Test
	public void demo(){
		Map<String,String> params = new HashMap<String, String>();
		params.put("mobile","123456");
		HttpsUtil.Post("http://172.17.1.224:8080/RongYi-Pay/testAjax", params, "UTF-8");
	}
	
	public static String Post(String url, Map<String, String> params, String charset) {
		ProtocolSocketFactory fcty = new MySecureProtocolSocketFactory();  
		Protocol.registerProtocol("https", new Protocol("https", fcty, 443));  
		
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
			e.printStackTrace();
			result = null;
		} 
		
		return result;
		
	}
	
	//@Test
	@SuppressWarnings("deprecation")
	public static String Get(String url){ 
		ProtocolSocketFactory fcty = new MySecureProtocolSocketFactory();  
		Protocol.registerProtocol("https", new Protocol("https", fcty, 443));  
       //String url = "https://api.shouqianba.com/Upay/weixinWapPay?sign=B55330EFA916D30C27ACBB32B47F8FA3&wechat_app_id=wx738b112b7e7bb8f3&open_id=ojOljw6AFUnPz8HOxzoWhMDtWuO0&total_fee=100.0&subject=abc123&notify_url=http=//app.loyalwm.com/weixin/notify_url&store_owner_order_sn=1452567338649&wosai_store_id=00009991001100100141837&client_ip=123.57.144.48&channel_id=14525044889274810&wosai_app_id=1001200200141837";
       HttpMethod method = null;
       String result = "";
		try {
			URI uri = new URI(url);
			// 定义HttpClient
			HttpClient client = new HttpClient();
			// 实例化HTTP方法
			GetMethod get = new GetMethod();
			get.setURI(uri);
			method = get;
			// 发送get请求
			int status = client.executeMethod(method);
			if(200 == status){
				result = method.getResponseBodyAsString();
			}
			//System.out.println(result);
		} catch (URIException e) {
			e.printStackTrace();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
}  
}
