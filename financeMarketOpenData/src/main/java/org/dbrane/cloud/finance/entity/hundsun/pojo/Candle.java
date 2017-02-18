/**
 * Project Name:org.dbrane.cloud
 * Module Name:financeMarketOpenData
 * GitHub:<a herf="github.com/isxujin">https://github.com/isxujin</a>
 * Copyright (c) 2000-2017 dbrane.org
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.dbrane.cloud.finance.entity.hundsun.pojo;

/**
 * 功能说明: K线持久对象
 * </br>
 * @author: xujin<a herf="mail:xujin@icloud.com"/>
 * @date: 2017年2月19日
 * @version: V1.0.0
 */
public class Candle {
	/**
	 * 分时分钟时间(HHMM)</br>
	 * 是否必填:false</br>
	 * 最大长度:10</br>
	 * 默认值:null</br>
	 */
	private Long minTime;

	/**
	 * 开盘价</br>
	 * 是否必填:false</br>
	 * 最大长度:10</br>
	 * 默认值:null</br>
	 */
	private Float openPx;
	
	/**
	 * 最高价</br>
	 * 是否必填:false</br>
	 * 最大长度:10</br>
	 * 默认值:null</br>
	 */
	private Float highPx;

	/**
	 * 最低价</br>
	 * 是否必填:false</br>
	 * 最大长度:10</br>
	 * 默认值:null</br>
	 */
	private Float lowPx;

	/**
	 * 收盘价</br>
	 * 是否必填:false</br>
	 * 最大长度:10</br>
	 * 默认值:null</br>
	 */
	private Float closePx;
	
	/**
	 * 成交数量</br>
	 * 是否必填:false</br>
	 * 最大长度:10</br>
	 * 默认值:null</br>
	 */
	private Integer businessAmount;

	/**
	 * 成交金额</br>
	 * 是否必填:false</br>
	 * 最大长度:16.2</br>
	 * 默认值:null</br>
	 */
	private Float businessBalance;

	/**
	 * @return the minTime
	 */
	public Long getMinTime() {
		return minTime;
	}

	/**
	 * @param minTime the minTime to set
	 */
	public void setMinTime(Long minTime) {
		this.minTime = minTime;
	}

	/**
	 * @return the openPx
	 */
	public Float getOpenPx() {
		return openPx;
	}

	/**
	 * @param openPx the openPx to set
	 */
	public void setOpenPx(Float openPx) {
		this.openPx = openPx;
	}

	/**
	 * @return the highPx
	 */
	public Float getHighPx() {
		return highPx;
	}

	/**
	 * @param highPx the highPx to set
	 */
	public void setHighPx(Float highPx) {
		this.highPx = highPx;
	}

	/**
	 * @return the lowPx
	 */
	public Float getLowPx() {
		return lowPx;
	}

	/**
	 * @param lowPx the lowPx to set
	 */
	public void setLowPx(Float lowPx) {
		this.lowPx = lowPx;
	}

	/**
	 * @return the closePx
	 */
	public Float getClosePx() {
		return closePx;
	}

	/**
	 * @param closePx the closePx to set
	 */
	public void setClosePx(Float closePx) {
		this.closePx = closePx;
	}

	/**
	 * @return the businessAmount
	 */
	public Integer getBusinessAmount() {
		return businessAmount;
	}

	/**
	 * @param businessAmount the businessAmount to set
	 */
	public void setBusinessAmount(Integer businessAmount) {
		this.businessAmount = businessAmount;
	}

	/**
	 * @return the businessBalance
	 */
	public Float getBusinessBalance() {
		return businessBalance;
	}

	/**
	 * @param businessBalance the businessBalance to set
	 */
	public void setBusinessBalance(Float businessBalance) {
		this.businessBalance = businessBalance;
	}

}
