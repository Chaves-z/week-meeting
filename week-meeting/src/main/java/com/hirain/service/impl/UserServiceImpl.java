package com.hirain.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirain.mapper.UserMapper;
import com.hirain.pojo.Result;
import com.hirain.pojo.User;
import com.hirain.service.UserService;
import com.hirain.utils.CookieUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public List<User> selectAll() {

		return userMapper.selectAll();
	}

	@Override
	public Result userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
		User user = userMapper.selectByUserName(username);
		//如果没有此用户名
		if (null == user) {
			return Result.build(400, "用户名或密码错误");
		}
		//比对密码
		//		if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
		//			return Result.build(400, "用户名或密码错误");
		//		}
		if (!password.equals(user.getPassword())) {
			return Result.build(400, "用户名或密码错误");
		}
		//生成token
		String token = String.valueOf(user.getId());
		//		String token = UUID.randomUUID().toString();
		//保存用户之前，把用户对象中的密码清空。
		user.setPassword(null);
		//把用户信息写入redis
		//		jedisClient.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
		//		//设置session的过期时间
		//		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);

		//添加写cookie的逻辑，cookie的有效期是关闭浏览器就失效。
		CookieUtils.setCookie(request, response, "TT_TOKEN", token);
		return Result.ok(token);

	}

}
