/**
 * Project Name:org.dbrane.cloud
 * Module Name:utils
 * GitHub:<a herf="github.com/isxujin">https://github.com/isxujin</a>
 * Copyright (c) 2000-2017 dbrane.org
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.dbrane.cloud.util.json;

import java.util.Map;

import org.dbrane.cloud.exception.BaseException;
import org.dbrane.cloud.exception.ErrorType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 功能说明: Jackson工具类 </br>
 * 
 * @author: xujin<a herf="mail:xujin@icloud.com"/>
 * @date: 2017年2月18日
 * @version: V1.0.0
 */
public class JacksonHelper {
	/**
	 * 日志句柄
	 */
	// private static final Logger logger =
	// LoggerFactory.getLogger(JacksonHelper.class);

	/**
	 * objectMapper对象实例(不做转换)
	 */
	private final static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * objectMapper对象实例(进行驼峰规则和下划线转换)
	 */
	private final static ObjectMapper objectMapperWithTranslate = new ObjectMapper();

	/**
	 * 将对象序列化成JSON字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String serialize(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			// logger.debug(ErrorType.Serialize.toString(), e);
			throw new BaseException(ErrorType.Serialize, e);
		}
	}

	/**
	 * 将对象序列化成JSON字符串,同时进行单词的驼峰规则和下划线分割规则转换
	 * 
	 * @param obj
	 * @return
	 */
	public static String serializeWithTranslate(Object obj) {
		try {
			return objectMapperWithTranslate.writeValueAsString(obj);
		} catch (Exception e) {
			// logger.debug(ErrorType.Serialize.toString(), e);
			throw new BaseException(ErrorType.Serialize, e);
		}
	}

	/**
	 * 将JSON字符串反序列化成对象
	 * 
	 * @param json
	 *            JSON字符串
	 * @param valueType
	 *            对象类型
	 * @return
	 */
	public static <T> T deserialize(String json, Class<T> valueType) {
		try {
			return objectMapper.readValue(json, valueType);
		} catch (Exception e) {
			// logger.debug(ErrorType.Deserialize.toString(), e);
			throw new BaseException(ErrorType.Deserialize, e);
		}
	}

	/**
	 * 将JSON字符串反序列化成集合对象
	 * 
	 * @param json
	 *            JSON
	 * @param typeReference
	 *            集合对象参考类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(String json, TypeReference<T> typeReference) {
		try {
			return (T) objectMapper.readValue(json, typeReference);
		} catch (Exception e) {
			// logger.debug(ErrorType.Deserialize.toString(), e);
			throw new BaseException(ErrorType.Deserialize, e);
		}
	}

	/**
	 * 将JSON字符串反序列化成对象,同时进行单词的驼峰规则和下划线分割规则转换
	 * 
	 * @param json
	 *            JSON字符串
	 * @param valueType
	 *            对象类型
	 * @return
	 */
	public static <T> T deserializeWithTranslate(String json, Class<T> valueType) {
		try {
			return objectMapperWithTranslate.readValue(json, valueType);
		} catch (Exception e) {
			// logger.debug(ErrorType.Deserialize.toString(), e);
			throw new BaseException(ErrorType.Deserialize, e);
		}
	}

	/**
	 * 对象转换成Map,同时进行单词的驼峰规则和下划线分割规则转换
	 * 
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> translate2Map(Object obj) {
		String json = serializeWithTranslate(obj);
		return deserialize(json, Map.class);
	}

	/**
	 * Map转换成对象,同时进行单词的驼峰规则和下划线分割规则转换
	 * 
	 * @param map
	 * @return
	 */
	public static <T> T translate2Object(Map<String,Object> map, Class<T> valueType) {
		String json = serialize(map);
		return deserializeWithTranslate(json, valueType);
	}

	/**
	 * 将JSON字符串反序列化成集合对象,同时进行单词的驼峰规则和下划线分割规则转换
	 * 
	 * @param json
	 *            JSON
	 * @param typeReference
	 *            集合对象参考类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deserializeWithTranslate(String json, TypeReference<T> typeReference) {
		try {
			return (T) objectMapperWithTranslate.readValue(json, typeReference);
		} catch (Exception e) {
			// logger.debug(ErrorType.Deserialize.toString(), e);
			throw new BaseException(ErrorType.Deserialize, e);
		}
	}

	static {
		/** ==objectMapper 初始化 == **/

		// 转换时，允许解析使用Java/C++ 样式的注释（包括'/'+'*' 和'//' 变量）。
		objectMapper.enable(JsonParser.Feature.ALLOW_COMMENTS);
		// 转换时，允许使用非双引号属性名字.
		objectMapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
		// 转换时，允许单引号来包住属性名称和字符串值。
		objectMapper.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
		// 转换时，允许JSON字符串包含非引号控制字符（值小于32的ASCII字符，包含制表符和换行符）。
		objectMapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS);
		// 转换时，允许接受所有引号引起来的字符，使用‘反斜杠\’机制.
		objectMapper.enable(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER);
		// 转换时，允许识别"Not-a-Number" (NaN)标识集合作为一个合法的浮点数。
		objectMapper.enable(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS);
		// 序列化时，关闭缩进功能
		objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
		// 序列化时，忽略空对象
		objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		// 反序列化时，忽略未知属性
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		// 序列化时 ，忽略值为null属性
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		// 设置属性名转换策略
		objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategy());

		/** == objectMapperWithTranslate 初始化 == **/

		// 转换时，允许解析使用Java/C++ 样式的注释（包括'/'+'*' 和'//' 变量）。
		objectMapperWithTranslate.enable(JsonParser.Feature.ALLOW_COMMENTS);
		// 转换时，允许使用非双引号属性名字.
		objectMapperWithTranslate.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
		// 转换时，允许单引号来包住属性名称和字符串值。
		objectMapperWithTranslate.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
		// 转换时，允许JSON字符串包含非引号控制字符（值小于32的ASCII字符，包含制表符和换行符）。
		objectMapperWithTranslate.enable(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS);
		// 转换时，允许接受所有引号引起来的字符，使用‘反斜杠\’机制.
		objectMapperWithTranslate.enable(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER);
		// 转换时，允许识别"Not-a-Number" (NaN)标识集合作为一个合法的浮点数。
		objectMapperWithTranslate.enable(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS);
		// 序列化时，关闭缩进功能
		objectMapperWithTranslate.disable(SerializationFeature.INDENT_OUTPUT);
		// 序列化时，忽略空对象
		objectMapperWithTranslate.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		// 反序列化时，忽略未知属性
		objectMapperWithTranslate.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// 序列化时 ，忽略值为null属性
		objectMapperWithTranslate.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		// 设置属性名转换策略
		objectMapperWithTranslate.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

	}

}
