/**
 * Project Name:org.dbrane.cloud
 * Module Name:financeMarketOpenData
 * GitHub:<a herf="github.com/isxujin">https://github.com/isxujin</a>
 * Copyright (c) 2000-2017 dbrane.org
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.dbrane.cloud.finance.entity.hundsun.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dbrane.cloud.finance.entity.hundsun.pojo.Candle;
import org.dbrane.cloud.util.json.JacksonHelper;

/**
 * 功能说明: K线响应对象 </br>
 * 
 * @author: xujin<a herf="mail:xujin@icloud.com"/>
 * @date: 2017年2月19日
 * @version: V1.0.0
 */
public class CandleDetail {
	/**
	 * K线
	 */
	private Map<String, Object> candle;

	/**
	 * @return the candle
	 */
	public Map<String, Object> getCandle() {
		return candle;
	}

	/**
	 * @param candle
	 *            the candle to set
	 */
	public void setCandle(Map<String, Object> candle) {
		this.candle = candle;
	}

	/**
	 * 获取产品编号
	 * 
	 * @return
	 */
	public String getProdCode() {
		if (null == candle) {
			return null;
		}
		for (String key : candle.keySet()) {
			if (!"fields".equals(key)) {
				return key;
			}
		}
		return null;
	}

	/**
	 * 获取K线列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Candle> getCandleList() {
		List<Candle> candleList = new ArrayList<Candle>();
		String prodCode = getProdCode();
		List<String> fields = (List<String>)candle.get("fields");
		List<List<Object>> values = (List<List<Object>>)candle.get(prodCode);
		for(List<Object> item:values){
			Map<String,Object> itemMap = new HashMap<String,Object>();
			for(int i=0;i<fields.size();i++){
				String field = fields.get(i);
				Object value = item.get(i);
				itemMap.put(field, value);
			}
			Candle candle = JacksonHelper.translate2Object(itemMap, Candle.class);
			candleList.add(candle);
		}
		return candleList;
	}

}
