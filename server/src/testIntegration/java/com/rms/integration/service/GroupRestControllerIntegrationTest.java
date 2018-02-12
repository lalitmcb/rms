package com.rms.integration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.stereotype.Service;

import com.rms.rest.GroupRestConstants;
import com.rms.rest.RestConstants;

@Service("groupRestControllerIntegrationTest")
public class GroupRestControllerIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	public void listGroup() {
		String body = this.restTemplate.getForObject(RestConstants.API+GroupRestConstants.GROUP_LIST, String.class);
	}
}
