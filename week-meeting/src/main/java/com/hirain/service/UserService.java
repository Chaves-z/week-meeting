package com.hirain.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hirain.pojo.Result;
import com.hirain.pojo.User;

public interface UserService {

	public List<User> selectAll();

	Result userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response);
}
