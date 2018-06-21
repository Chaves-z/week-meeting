package com.hirain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.hirain.pojo.User;

public interface UserMapper {

	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	@Select("select * from user ")
	List<User> selectAll();

	User selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	@Select("select * from user where userName=#{username}")
	User selectByUserName(String username);
}