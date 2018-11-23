package com.usel.app.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.usel.app.model.Customer;
import com.usel.app.service.CustomerService;
import com.usel.app.service.exception.ServiceException;
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
