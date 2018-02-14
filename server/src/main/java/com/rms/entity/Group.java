package com.rms.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.rms.vo.GroupVO;

import lombok.Data;

@Entity
@Table(name = "groups")
@Data
public class Group implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups_sequence")
	@SequenceGenerator(name="groups_sequence", sequenceName = "groups_seq", allocationSize=50)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	public GroupVO toVO() {
		GroupVO groupVO = new GroupVO();
		groupVO.setId(id);
		groupVO.setName(name);
		return groupVO;
	}
	
	public static List<GroupVO> toVOList(List<Group> groupList){
		List<GroupVO> groupVOList = new ArrayList<>(groupList.size());
		
		for(Group group:groupList) {
			GroupVO groupVO = group.toVO();
			groupVOList.add(groupVO);
		}
		
		return groupVOList; 
	}
}
