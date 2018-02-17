package com.rms.rest;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rms.service.UserService;
import com.rms.vo.UserVO;

@RestController
@RequestMapping(value=RestConstants.API)
public class UserRestController {

	@Resource
	UserService userService;
	
	@RequestMapping(value="/user/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<UserVO> getListOfGroup(@RequestBody final UserVO userVO){
		UserVO persistedUserVO = userService.createUser(userVO);	
		return new ResponseEntity<UserVO>(persistedUserVO, HttpStatus.OK);
	
	}
	
	
}
