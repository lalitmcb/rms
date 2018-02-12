package com.rms.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rms.service.GroupService;
import com.rms.vo.GroupVO;

@RestController
@RequestMapping(value=RestConstants.API)
public class GroupRestController {

	@Resource
	GroupService groupService;
	
	@RequestMapping(value=GroupRestConstants.GROUP_LIST, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<GroupVO>> getListOfGroup(){
		List<GroupVO> gVOList = new ArrayList<>();
		
		GroupVO gv1 = new GroupVO();
		gv1.setId(1L);
		gv1.setName("Engineering");
		gVOList.add(gv1);
		
		return new ResponseEntity<List<GroupVO>>(gVOList, HttpStatus.OK);
	
	}
}
