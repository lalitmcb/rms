package com.rms.service;

import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rms.entity.User;
import com.rms.repository.UserRepository;
import com.rms.vo.NewUserVO;
import com.rms.vo.UserVO;

@Service("userService")
public class UserService {
	
	@Resource
	UserRepository userRepository;
	
	@Resource
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserVO createUser(NewUserVO newUserVO) {
		User user = newUserVO.toEntity();
		user.setPassword(bCryptPasswordEncoder.encode(newUserVO.getPassword()));
		user = userRepository.save(user);
		UserVO userVO = user.toVO();
		return userVO;
	}
}
