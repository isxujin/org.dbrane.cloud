/**
 * Project Name:org.dbrane.cloud
 * Module Name:utils
 * GitHub:<a herf="github.com/isxujin">https://github.com/isxujin</a>
 * Copyright (c) 2000-2017 dbrane.org
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.dbrane.cloud.exception;

/**
 * 功能说明: 错误类型</br>
 * 
 * @author: xujin<a herf="mail:xujin@icloud.com"/>
 * @date: 2017年2月18日
 * @version: V1.0.0
 */
public enum ErrorType {
	/**
	 * 未定义错误
	 */
	Undefined("undefined_error"),
	
	/**
	 * 序列化错误
	 */
	Serialize("serialize_error"),

	/**
	 * 反序列化错误
	 */
	Deserialize("deserialize_error"),
	
	/**
	 * HttpClient错误
	 */
	Httpclient("httpclient_error");

	/**
	 * 错误类型值
	 */
	private String value;

	/**
	 * 构造方法
	 * 
	 * @param value
	 */
	private ErrorType(String value) {
		this.value = value;
	}

	/**
	 * 获取错误类型值
	 * 
	 * @return
	 */
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.value;
	}

}
