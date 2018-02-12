package com.rms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rms.entity.Group;
import com.rms.repository.GroupRepository;

@Service("groupService")
public class GroupService {
	
	@Resource
	GroupRepository groupRepository;
	
	public List<Group> getListOfGroup(){
		return groupRepository.findAll();
	}

}
