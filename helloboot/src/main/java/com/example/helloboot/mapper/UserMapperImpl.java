package com.example.helloboot.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helloboot.model.UserBean;

@Service
public class UserMapperImpl implements UserInterface{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<UserBean> getAllUser() {
		return userMapper.getAllUser();
	}

}
