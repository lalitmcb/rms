package com.rms.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rms.service.UserService;
import com.rms.vo.GroupVO;

@RestController
@RequestMapping(value=RestConstants.API)
public class UserRestController {

	@Resource
	UserService userService;
	
	
	
	
}
