package com.hirain.controller;

import java.io.UnsupportedEncodingException;
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

	@RequestMapping(value = "/test")
	@ResponseBody
	public List<User> selectAllUser() {

		return userService.selectAll();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save")
	@ResponseBody
	public Result save(HttpServletRequest request, @RequestBody String param) throws UnsupportedEncodingException {

		Map<String, Object> planMap = (Map<String, Object>) ConvertJson.convertJsonToMap(URLDecoder.decode(param, "utf-8"));
		Boolean save = contentService.save(planMap);
		Result result = new Result();
		result.setCode(200);
		result.setData(save);
		return result;
	}
}
