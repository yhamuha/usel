package com.usel.app.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;


@RunWith(SpringRunner.class)
public class FinalPoNumberControllerTest {
	
	@Test
	public void ifAllSuccess_then200_OK() throws Exception {
		
		   HttpUriRequest request = new HttpPost("http://192.168.99.100/api/finalponumber/");
		   HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		   assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_CREATED));
		   
	}
}
