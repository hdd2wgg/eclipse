package com.example.helloboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.helloboot.model.User;

@Mapper
public interface UserMapper {

	// 查询所有用户
	@Select("select * from t_user")
	List<User> getAllUser();
}
