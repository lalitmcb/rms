package com.rms.rest;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rms.service.UserService;

@RestController
@RequestMapping(value=RestConstants.API)
public class UserRestController {

	@Resource
	UserService userService;
	
	
	
	
}
