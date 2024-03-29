package com.jay.utils;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MongoUtil {

	public static synchronized Map<String, Object> convertToMap(Object obj) {
		ObjectMapper oMapper = new ObjectMapper();
		oMapper.setSerializationInclusion(Include.NON_NULL);
		Map<String, Object> objectMap = oMapper.convertValue(obj, new TypeReference<Map<String, Object>>() {
		});
		return objectMap;
	}

	public static Object convertToEntity(Class<?> persistentClass, Map<String, Object> entityMap) {
		ObjectMapper oMapper = new ObjectMapper();
		oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Object pojo = oMapper.convertValue(entityMap, persistentClass);
		return pojo;
	}

}
