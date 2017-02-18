/**
 * Project Name:org.dbrane.cloud
 * Module Name:utils
 * GitHub:<a herf="github.com/isxujin">https://github.com/isxujin</a>
 * Copyright (c) 2000-2017 dbrane.org
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.dbrane.cloud.exception;

import java.io.Serializable;

/**
 * 功能说明: </br>
 * 
 * @author: xujin<a herf="mail:xujin@icloud.com"/>
 * @date: 2017年2月18日
 * @version: V1.0.0
 */
@SuppressWarnings("serial")
public class ErrorMetaInfo implements Serializable {
	/**
	 * 错误编号
	 */
	private String errorCode;

	/**
	 * 错误信息
	 */
	private String errorMessage;

	/**
	 * 错误线程标识
	 */
	private Long threadId;

	/**
	 * 错误生成时间
	 */
	private Long timestamp;

	/**
	 * 默认构造
	 */
	public ErrorMetaInfo() {
		this(null, null);
	}

	/**
	 * 带参构造
	 * 
	 * @param errorMessage
	 *            错误信息
	 */
	public ErrorMetaInfo(String errorMessage) {
		this(null, errorMessage);
	}

	/**
	 * 带参构造
	 * 
	 * @param errorCode
	 *            错误编号
	 * @param errorMessage
	 *            错误信息
	 */
	public ErrorMetaInfo(String errorCode, String errorMessage) {
		threadId = Thread.currentThread().getId();
		timestamp = System.currentTimeMillis();
		if (null == errorCode) {
			this.errorCode = ErrorType.Undefined.toString();
		} else {
			this.errorCode = errorCode;
		}
		this.errorMessage = errorMessage;
	}

	public ErrorMetaInfo(String errorCode, String errorMessage, Long threadId, Long timestap) {
		this(errorCode, errorMessage);
		if (null != threadId)
			this.threadId = threadId;
		if (null != timestap)
			this.timestamp = timestap;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the threadId
	 */
	public Long getThreadId() {
		return threadId;
	}

	/**
	 * @return the timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}

}
