package com.rms.integration;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriTemplateHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rms.integration.template.LoginRestControllerTemplate;
import com.rms.security.LoginVO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:testIntegration.properties")
@Configuration
public class RMSIntegrationTest{
	
	private static Logger logger = Logger.getLogger(RMSIntegrationTest.class);
	
	@LocalServerPort
    private int port;
	

	@Autowired
	ApplicationContext context;
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
	
	@Test
	public void test() throws JsonProcessingException {
	
		String baseURI = "http://localhost:" + port ;
		UriTemplateHandler uriTemplateHandler = new DefaultUriBuilderFactory(baseURI);		
		testRestTemplate.setUriTemplateHandler(uriTemplateHandler);
		testRestTemplate.getRestTemplate().setInterceptors(
		        Collections.singletonList((request, body, execution) -> {
		            request.getHeaders()
		                    .add("Content-Type", "applicatioon/json");
		            return execution.execute(request, body);
		        }));


		LoginRestControllerTemplate loginRestControllerTemplate = context.getBean(LoginRestControllerTemplate.class);

		//Check for unauthroized access
		LoginVO loginVO = new LoginVO();
		loginVO.setEmail("admin@admin.admin.khalibali");
		loginVO.setPassword("kidnap_presi#");
		ResponseEntity<String> response = loginRestControllerTemplate.login(loginVO);
		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCodeValue());
		
		//Check for authorized access
		loginVO = new LoginVO();
		loginVO.setEmail("admin@admin.admin.khalibali");
		loginVO.setPassword("kidnap_president#");
		response = loginRestControllerTemplate.login(loginVO);
		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCodeValue());
		
	}



}
