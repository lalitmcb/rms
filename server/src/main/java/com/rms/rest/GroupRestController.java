package com.rms.rest;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rms.service.GroupService;
import com.rms.vo.GroupVO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping(value=RestConstants.API)
public class GroupRestController {

	@Resource
	GroupService groupService;
	
	@RequestMapping(value="/group/list", method = RequestMethod.GET, produces = "application/json")
	 @ApiImplicitParams({
	        @ApiImplicitParam(name = "page", dataType = "string", paramType = "query", defaultValue = "0",
	                value = "Results page you want to retrieve (0..N)"),
	        @ApiImplicitParam(name = "size", dataType = "string", paramType = "query", defaultValue = "25",
	                value = "Number of records per page."),
	        @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Direction of sort")
	})
	public ResponseEntity<Page<GroupVO>> getListOfGroup(Pageable pageable){
		Page<GroupVO> groupVOPage = groupService.getGroupVOPage(pageable);		
		return new ResponseEntity<>(groupVOPage, HttpStatus.OK);
	}

	@RequestMapping(value="/group", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<GroupVO> createGroup(@RequestBody final GroupVO groupVO){
		GroupVO persistedGroupVO = groupService.createGroup(groupVO);	
		return new ResponseEntity<>(persistedGroupVO, HttpStatus.OK);
	
	}
}
