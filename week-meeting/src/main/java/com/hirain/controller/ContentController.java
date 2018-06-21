package com.hirain.controller;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hirain.pojo.Result;
import com.hirain.pojo.User;
import com.hirain.service.ContentService;
import com.hirain.service.UserService;
import com.hirain.utils.ConvertJson;

@Controller
public class ContentController {

	@Autowired
	UserService userService;

	@Autowired
	ContentService contentService;

	@RequestMapping(value = "/getUsers")
	@ResponseBody
	public List<User> selectAllUser() {

		return userService.selectAll();
	}

	@RequestMapping(value = "/getUser")
	@ResponseBody
	public User selectUser() {

		return null;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save")
	@ResponseBody
	public Result save(HttpServletRequest request, @RequestBody String param) {

		Result result = new Result();
		Map<String, Object> planMap;
		try {
			planMap = (Map<String, Object>) ConvertJson.convertJsonToMap(URLDecoder.decode(param, "utf-8"));
			Boolean save = contentService.save(planMap);
			result.setStatus(200);
			result.setData(save);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(500);
			result.setMsg(e.getMessage());
		}
		return result;
	}
}
