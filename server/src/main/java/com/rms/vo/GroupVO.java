package com.rms.vo;

import com.rms.entity.Group;

import lombok.Data;

@Data
public class GroupVO {

	private Long id;
	private String name;
	
	public Group toEntity() {
		Group group = new Group();
		group.setId(id);
		group.setName(name);
		return group;
	}
}
