package com.mooop.m.j8.net;

import java.net.URI;
import java.util.HashMap;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

public class NetMain {
	
//	private final static String TEST_URL = "http://localhost:8080/mtw/static/sample";
	private final static String TEST_URL = "http://localhost:8080/api/test";
	
	
	
	
	private static HttpClient newClient(boolean ssl) throws Exception{
		if(ssl) {
			SSLContext sslContext = SSLContextBuilder.create()
					.loadTrustMaterial(new TrustSelfSignedStrategy())
					.build();

			HostnameVerifier allowAllHosts = new NoopHostnameVerifier();
			
			SSLConnectionSocketFactory connectionFactory = new SSLConnectionSocketFactory(sslContext , allowAllHosts);
			return HttpClients.custom().setSSLSocketFactory(connectionFactory).build();
		}else {
			return HttpClientBuilder.create().build();
		}
		
	}
	
	
	private static void post(String _url) {
		try {
			//1. 객체 생성
			HttpClient client = newClient(false);
			
			//2. Post 요청 설정
			HttpPost postRequest = new HttpPost(_url);
			postRequest.addHeader("Content-Type", "application/json");
			postRequest.addHeader("Accept" , "application/json");
			
			//3. RequestBody 셋팅
			HashMap<String , String> m = new HashMap<>();
			m.put("name", "xferlog");
			m.put("age", "28");
			ObjectMapper om = new ObjectMapper();
			String jsonString = om.writeValueAsString(m);
			System.out.println(jsonString);
			StringEntity params = new StringEntity(jsonString);
			postRequest.setEntity(params);
			
			
			//4. 서버에 POST 요청
			HttpResponse response = client.execute(postRequest);
			
			//5. Response 파싱및 출력
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity);
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject) parser.parse(content);
			jsonObj.forEach((k , v)->System.out.println(k+":"+v));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static void get(String _url) {
		try {
			
			//1. 객체 생성
			HttpClient httpClient  = newClient(true);
			
			//2. uri설정 ( 파라미터셋팅)
			URI uri = new URI(_url);
			uri = new URIBuilder( uri ).addParameter("name", "곽경진").addParameter("age", "29").build();
			System.out.println(uri.getQuery());
			
			//3. 서버에 GET 요청
			HttpResponse response = httpClient.execute(new HttpGet(uri));
			
			//4. Response 파싱및 출력
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity);
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject) parser.parse(content);
			jsonObj.forEach((k , v)->System.out.println(k+":"+v));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static void test1() {
		
		try {
			
			
		
			get(TEST_URL);
			
//			post(TEST_URL);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		test1();
	}

}
