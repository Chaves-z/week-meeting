package com.hirain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String index() {

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login() {

		return "index";
	}
}
