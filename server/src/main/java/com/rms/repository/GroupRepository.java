package com.rms.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rms.entity.Group;

@Repository("groupRepository")
public interface GroupRepository extends PagingAndSortingRepository<Group, Long> {

}
