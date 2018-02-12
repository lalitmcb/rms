package com.rms.integration;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.rms.integration.service.GroupRestControllerIntegrationTest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RMSIntegrationTest {

	@Resource
	GroupRestControllerIntegrationTest groupRestControllerIntegrationTest;
	
	@Test
	public void test() {
		groupRestControllerIntegrationTest.listGroup();
	}

}
