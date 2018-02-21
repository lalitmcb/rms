package com.rms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rms.entity.Group;
import com.rms.repository.GroupRepository;
import com.rms.vo.GroupVO;

@Service("groupService")
public class GroupService {
	
	@Resource
	GroupRepository groupRepository;
	
	public List<GroupVO> getGroupVOList(){
		List<Group> groupList = groupRepository.findAll();
		return Group.toVOList(groupList);
	}
	
	public GroupVO createGroup(GroupVO groupVO) {
		Group group = groupVO.toEntity();
		group = groupRepository.save(group);
		groupVO = group.toVO();
		return groupVO;
	}

}
