package com.rms.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value=RestConstants.API)
public class LoginRestController {

	@RequestMapping(value=LoginRestConstants.LOGIN, method = RequestMethod.POST, produces = "application/json")
	public void login() {
		
	}
	
	@RequestMapping(value=LoginRestConstants.LOGOUT, method = RequestMethod.GET, produces = "application/json")
	public void logout() {
		
	}
}
