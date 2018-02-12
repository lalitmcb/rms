package com.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.entity.Group;

@Repository("groupRepository")
public interface GroupRepository extends JpaRepository<Group, Long> {

}
