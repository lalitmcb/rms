package com.rms.service;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rms.entity.Group;
import com.rms.repository.GroupRepository;
import com.rms.vo.GroupVO;

@Service("groupService")
public class GroupService {
	
	@Resource
	GroupRepository groupRepository;
	
	public Page<GroupVO> getGroupVOPage(Pageable pageable){
		Page<Group> groupList = groupRepository.findAll(pageable);
		return toVOList(groupList);
	}
	
	public GroupVO createGroup(GroupVO groupVO) {
		Group group = toEntity(groupVO);
		group = groupRepository.save(group);
		groupVO = toVO(group);
		return groupVO;
	}

	public GroupVO toVO(final Group group) {
		GroupVO groupVO = new GroupVO();
		groupVO.setId(group.getId());
		groupVO.setName(group.getName());
		return groupVO;
	}

	public Page<GroupVO> toVOList(Page<Group> groupPage) {
		return groupPage.map(this::toVO);
	}
	
	public Group toEntity(GroupVO groupVO) {
		Group group = new Group();
		group.setId(groupVO.getId());
		group.setName(groupVO.getName());
		return group;
	}
}
