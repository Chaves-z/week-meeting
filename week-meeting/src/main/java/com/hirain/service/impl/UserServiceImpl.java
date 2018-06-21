package com.hirain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirain.mapper.UserMapper;
import com.hirain.pojo.User;
import com.hirain.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public List<User> selectAll() {

		return userMapper.selectAll();
	}

}
