/**
 * Project Name:org.dbrane.cloud
 * Module Name:utils
 * GitHub:<a herf="github.com/isxujin">https://github.com/isxujin</a>
 * Copyright (c) 2000-2017 dbrane.org
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.dbrane.cloud.exception;

/**
 * 功能说明: 平台基础运行时异常 </br>
 * 
 * @author: xujin<a herf="mail:xujin@icloud.com"/>
 * @date: 2017年2月18日
 * @version: V1.0.0
 */
@SuppressWarnings("serial")
public class BaseException extends RuntimeException {
	/**
	 * 异常类型
	 */
	private ErrorMetaInfo errorMetaInfo;

	/**
	 * 默认构造
	 */
	public BaseException() {
		this(null, null, null);
	}

	public BaseException(ErrorType type) {
		this(type, null, null);
	}

	public BaseException(String message) {
		this(null, message, null);
	}

	public BaseException(ErrorType type, String message) {
		this(type, message, null);
	}

	public BaseException(Throwable cause) {
		this(null, cause.getMessage(), cause);
	}

	public BaseException(ErrorType type, Throwable cause) {
		this(type, cause.getMessage(), cause);
	}

	public BaseException(String message, Throwable cause) {
		this(null, message, cause);
	}

	/**
	 * 带参构造
	 * 
	 * @param type
	 *            错误类型
	 * @param message
	 *            错误信息
	 * @param cause
	 *            错误原因堆栈
	 */
	public BaseException(ErrorType type, String message, Throwable cause) {
		super(message, cause);
		errorMetaInfo = new ErrorMetaInfo((null != type) ? type.getValue() : null, super.getMessage());
	}

	/**
	 * @return the errorMetaInfo
	 */
	public ErrorMetaInfo getErrorMetaInfo() {
		return errorMetaInfo;
	}
	
}
