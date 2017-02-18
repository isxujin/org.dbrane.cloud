/**
 * Project Name:org.dbrane.cloud
 * Module Name:restClientWithFeign
 * GitHub:<a herf="github.com/isxujin">https://github.com/isxujin</a>
 * Copyright (c) 2000-2017 dbrane.org
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.dbrane.cloud.service.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dbrane.cloud.common.Constants;
import org.dbrane.cloud.entity.hundsun.request.KLineRequest;
import org.dbrane.cloud.entity.hundsun.response.Candle;
import org.dbrane.cloud.util.httpclient.HttpClientHelper;
import org.dbrane.cloud.util.json.JacksonHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能说明: 恒生开放服务 </br>
 * 
 * @author: xujin<a herf="mail:xujin@icloud.com"/>
 * @date: 2017年2月18日
 * @version: V1.0.0
 */
@RestController
@RequestMapping("/hundsun")
public class HundsunService {
	private static String accessToken;

	/**
	 * 获取访问令牌
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/token")
	public String token() {
		try {
			String result = HttpClientHelper.httpGetRequest("http://light.hs.net/auth.json");
			Map<String, Object> json = JacksonHelper.deserialize(result, Map.class);
			accessToken = (String) json.get("access_token");
			return accessToken;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/kline/{code}/{date}/{type}")
	public String kline(@PathVariable String code, @PathVariable Integer date, @PathVariable Integer type) {
		if (null == code || code.length() != 6) {
			return null;
		}
		if(null==type||type<1||type>9){
			return null;
		}
		
		String url = Constants.OPEN_HOST_HUNDSUN + "/quote/v1/kline";
		KLineRequest request = new KLineRequest();
		String prodCode = null;
		if (code.startsWith("6")) {
			prodCode = code + ".SS";
		}else if(code.startsWith("0")||code.startsWith("3")){
			prodCode = code + ".SZ";
		}
		request.setProdCode(prodCode);
		request.setStartDate(date);
		request.setGetType("range");
		request.setCandlePeriod(type);
		request.setMinTime(900);

		Map<String, Object> params = JacksonHelper.translate2Map(request);
		String json = HttpClientHelper.httpPostRequest(url, getAuthorizationHeaders(), params);
		Map<String,Object> result = JacksonHelper.deserialize(json, Map.class);
		//解包
		if(null!=result){
			Map tempMap =(Map) ((Map)result.get("data")).get("candle");
			List<String> fields = (List)tempMap.get("fields");
			List<List> datas = (List)tempMap.get(prodCode);
			List<Candle> candleList = new ArrayList<Candle>();
			for(List item : datas){
				Map<String,Object> candleMap = new HashMap<String,Object>();
				candleMap.put("prod_code", prodCode);
				for(int i=0;i<fields.size();i++){
					String field = fields.get(i);
					Object value = item.get(i);
					candleMap.put(field, value);
				}
				Candle candle = JacksonHelper.translate2Object(candleMap, Candle.class);
				candleList.add(candle);
			}
			json = JacksonHelper.serialize(candleList);
			return json;
		}else{
			return null;
		}
	}

	/**
	 * 获取安全头信息
	 * 
	 * @return
	 */
	private Map<String, Object> getAuthorizationHeaders() {
		if (null == accessToken || accessToken.length() <= 0) {
			accessToken = token();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Authorization", "Bearer " + accessToken);
		return map;
	}
}
