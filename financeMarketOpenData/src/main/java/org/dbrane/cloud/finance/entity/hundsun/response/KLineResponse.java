/**
 * Project Name:org.dbrane.cloud
 * Module Name:financeMarketOpenData
 * GitHub:<a herf="github.com/isxujin">https://github.com/isxujin</a>
 * Copyright (c) 2000-2017 dbrane.org
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.dbrane.cloud.finance.entity.hundsun.response;

/**
 * 功能说明: K线响应对象
 * </br>
 * @author: xujin<a herf="mail:xujin@icloud.com"/>
 * @date: 2017年2月19日
 * @version: V1.0.0
 */
public class KLineResponse {
	
	private CandleDetail data;

	/**
	 * @return the data
	 */
	public CandleDetail getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(CandleDetail data) {
		this.data = data;
	}
	
	
}
