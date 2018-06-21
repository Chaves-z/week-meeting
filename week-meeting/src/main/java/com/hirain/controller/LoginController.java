package com.hirain.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.hirain.pojo.Result;
import com.hirain.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String login() {

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(String username, String password, HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		if (StringUtils.isEmpty(username)) {
			mav.addObject("msg", "用户名不能为空");
			return mav;
		} else if (StringUtils.isEmpty(password)) {
			mav.addObject("msg", "密码不能为空");
			return mav;
		}
		try {
			Result result = userService.userLogin(username, password, request, response);
			if (result.getStatus() == 200) {
				mav.setViewName("index");
			} else {
				mav.addObject("msg", "用户名或密码错误");
				mav.setViewName("login");
			}
			return mav;
		} catch (Exception e) {
			mav.addObject("msg", "用户名或密码错误");
			mav.setViewName("login");
			return mav;
		}
	}
}
