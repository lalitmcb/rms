package com.rms.service;

import java.util.UUID;

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
	
	public UserVO createUser(UserVO userVO) {
		User user = userVO.toEntity();
		user.setPassword(bCryptPasswordEncoder.encode(UUID.randomUUID().toString()));
		user = userRepository.save(user);
		userVO = user.toVO();
		return userVO;
	}
}
