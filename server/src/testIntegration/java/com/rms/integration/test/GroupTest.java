package com.rms.integration.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rms.integration.template.GroupRestControllerTemplate;

@Service("groupTest")
public class GroupTest {
	
	@Resource
	GroupRestControllerTemplate groupRestControllerTemplate;

	public void testForAdmin() {
		
		
	}
}
