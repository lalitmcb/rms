package com.rms.integration.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("loginRestControllerTemplate")
public class LoginRestControllerTemplate {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public ResponseEntity<String> login(String  loginJson) throws JsonProcessingException {
		HttpEntity<String> httpEntity = new HttpEntity<>(loginJson, null);
		return testRestTemplate.postForEntity("/login",httpEntity, String.class);
	}
	
}

