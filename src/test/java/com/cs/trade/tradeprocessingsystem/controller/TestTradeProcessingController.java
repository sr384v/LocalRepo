package com.cs.trade.tradeprocessingsystem.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class TestTradeProcessingController {

	@Test
	public void testTomcatServerStatus() throws ClientProtocolException, IOException {
		/*check if tomcat server is up.. just to see happy path*/
		
		HttpUriRequest request = new HttpGet( "http://localhost:8080/tradeprocessingsystem/");
		 HttpResponse httpResponse;
		
			httpResponse = HttpClientBuilder.create().build().execute( request );
			
			System.out.println(HttpClientBuilder.create().build().execute( request ));
			assertThat(
				     httpResponse.getStatusLine().getStatusCode(),
				     equalTo(HttpStatus.SC_OK));
		
	}
	
	@Test
	public void testResponseFromServer() throws ClientProtocolException, IOException {
	//	check if we are getting 200 response
		HttpUriRequest request = new HttpGet( "http://localhost:8080/tradeprocessingsystem/");
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		assertThat(
			     httpResponse.getStatusLine().getStatusCode(),
			     equalTo(HttpStatus.SC_OK));
		StringEntity requestEntity = new StringEntity(
				"application/json",
			    ContentType.APPLICATION_JSON);

			HttpPost postMethod = new HttpPost("http://localhost:8080/tradeprocessingsystem/");
			postMethod.setEntity(requestEntity);
	}
	
	 @Test
	    public void testValueDateTradeDate() throws ClientProtocolException, IOException{
		 HttpPost post = new HttpPost("http://localhost:8080/tradeprocessingsystem/webapi/trade/validateTrades");
		    post.addHeader("Content-Type", "application/json");
		    StringEntity entity;
	
				//entity = new StringEntity("{\"amount1\":1000000.0,\"amount2\":1120000.0,\"ccyPair\":\"EURUSD\",\"customer\":\"JUPITER1\",\"direction\":\"BUY\",\"legalEntity\":\"CS London\",\"rate\":1.17,\"tradeDate\":\"2018-08-11T00:00:00Z[UTC]\",\"trader\":\"JohannBaumfiddler\",\"type\":\"Spot\",\"valueDate\":\"2016-08-15T00:00:00Z[UTC]\"}");
				entity = new StringEntity("{\"customer\":\"JUPITER1\",\"ccyPair\":\"EURUSD\",\"type\":\"Spot\",\"direction\":\"BUY\",\"tradeDate\":\"2018-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"valueDate\":\"2016-08-15\",\"legalEntity\":\"CS London\",\"trader\":\"JohannBaumfiddler\"}");
				post.setEntity(entity);
			
		    
		    DefaultHttpClient client = new DefaultHttpClient();
				
				HttpResponse response = client.execute(post);			
				assertEquals("[Value Date cannot be before Trade Date]".trim(), EntityUtils.toString(response.getEntity()).trim());
				client.close();

		    
	      
	    }


}
