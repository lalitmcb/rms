package com.rms.rest;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rms.service.UserService;
import com.rms.vo.NewUserVO;
import com.rms.vo.UserVO;

@RestController
public class SignUpRestController {

	@Resource
	UserService userService;
	
	@RequestMapping(value="/signUp", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<UserVO> createUser(@RequestBody final NewUserVO newUserVO){
		UserVO persistedUserVO = userService.createUser(newUserVO);	
		return new ResponseEntity<>(persistedUserVO, HttpStatus.OK);
	
	}
	
	
}
