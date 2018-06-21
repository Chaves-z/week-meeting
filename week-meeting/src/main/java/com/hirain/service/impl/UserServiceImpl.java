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
		//���û�д��û���
		if (null == user) {
			return Result.build(400, "�û������������");
		}
		//�ȶ�����
		//		if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
		//			return Result.build(400, "�û������������");
		//		}
		if (!password.equals(user.getPassword())) {
			return Result.build(400, "�û������������");
		}
		//����token
		String token = String.valueOf(user.getId());
		//		String token = UUID.randomUUID().toString();
		//�����û�֮ǰ�����û������е�������ա�
		user.setPassword(null);
		//���û���Ϣд��redis
		//		jedisClient.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
		//		//����session�Ĺ���ʱ��
		//		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);

		//���дcookie���߼���cookie����Ч���ǹر��������ʧЧ��
		CookieUtils.setCookie(request, response, "TT_TOKEN", token);
		return Result.ok(token);

	}

}
