package com.hirain.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ConvertJson {

	public static Map<?, ?> convertJsonToMap(String jsonStr) {

		ObjectMapper mapper = new ObjectMapper();
		Map<?, ?> map = null;
		try {
			map = mapper.readValue(jsonStr, Map.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static Object convertJsonToBean(String jsonStr, Object obj) {

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		Object newObj = null;
		try {
			jsonStr = URLDecoder.decode(URLEncoder.encode(jsonStr, "utf-8"), "utf-8");
			newObj = mapper.readValue(jsonStr, obj.getClass());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newObj;
	}

	public static Map<?, ?> convertJsonToMap(String jsonStr, String encoding) throws UnsupportedEncodingException {

		String jsonFormatStr = URLDecoder.decode(jsonStr, encoding);
		return convertJsonToMap(jsonFormatStr);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, ? extends Object> getObjMap(String jsonStr) {

		Map<String, Object> objInfoMap = new HashMap<String, Object>();
		try {
			objInfoMap = (Map<String, Object>) ConvertJson.convertJsonToMap(jsonStr, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return objInfoMap;
	}
}
