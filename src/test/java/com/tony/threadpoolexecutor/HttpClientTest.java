package com.tony.threadpoolexecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientTest {

	
	public static void main(String[] args) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("http://www.baidu.com");
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
		    HttpEntity entity = response.getEntity();
		    if (entity != null) {
		        System.out.println(entity.isRepeatable());
		        System.out.println(entity.isStreaming());
		        BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
		        while(true){
		        	String line  = reader.readLine();
		        	if(null!=line){
		        		System.out.println(line);
		        		System.out.println("-----------------------------------");
		        	}else
		        		break;
		        }
		    }
		} finally {
		    response.close();
		}
	}
}
