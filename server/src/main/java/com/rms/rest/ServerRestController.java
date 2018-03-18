package com.rms.rest;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rms.service.ServerService;
import com.rms.vo.ServerDetailsVO;

@RestController
@RequestMapping(value = RestConstants.API)
public class ServerRestController {

	@Resource
	ServerService serverService;

	@RequestMapping(value = "/server/details", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ServerDetailsVO> getServerDetails() {
		try {
			ServerDetailsVO serverDetailsVO = serverService.getServerDetails();
			return new ResponseEntity<>(serverDetailsVO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		}

	}
}
