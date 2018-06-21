package com.hirain.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.hirain.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Override
	public Boolean save(Map<String, Object> params) {

		for (Map.Entry<String, Object> param : params.entrySet()) {
			System.out.println(param.getKey() + ":" + param.getValue());
		}
		return null;
	}

}
