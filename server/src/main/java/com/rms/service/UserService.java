package com.rms.service;

import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rms.entity.User;
import com.rms.repository.UserRepository;
import com.rms.vo.UserVO;

@Service("userService")
public class UserService {
	
	@Resource
	UserRepository userRepository;
	
	@Resource
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void createUser(UserVO userVO) {
		User user = userVO.toEntity();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
}
