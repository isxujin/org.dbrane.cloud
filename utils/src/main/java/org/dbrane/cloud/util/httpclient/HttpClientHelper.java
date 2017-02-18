/**
 * Project Name:org.dbrane.cloud
 * Module Name:utils
 * GitHub:<a herf="github.com/isxujin">https://github.com/isxujin</a>
 * Copyright (c) 2000-2017 dbrane.org
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.dbrane.cloud.util.httpclient;

import java.util.ArrayList;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dbrane.cloud.exception.BaseException;
import org.dbrane.cloud.exception.ErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能说明: HttpClient工具类</br>
 * 
 * @author: xujin<a herf="mail:xujin@icloud.com"/>
 * @date: 2017年2月18日
 * @version: V1.0.0
 */
public class HttpClientHelper {
	/**
	 * 日志句柄
	 */
	private static final Logger logger = LoggerFactory.getLogger(HttpClientHelper.class);
	private static PoolingHttpClientConnectionManager cm;
	private static String EMPTY_STR = "";
	private static String UTF_8 = "UTF-8";
	private static Byte lock = 0;

	private static void init() {
		if (null == cm) {
			synchronized (lock) {
				if (cm == null) {
					cm = new PoolingHttpClientConnectionManager();
					cm.setMaxTotal(50);// 整个连接池最大连接数
					cm.setDefaultMaxPerRoute(5);// 每路由最大连接数，默认值是2
				}
			}
		}
	}

	/**
	 * 通过连接池获取HttpClient
	 * 
	 * @return
	 */
	private static CloseableHttpClient getHttpClient() {
		init();
		return HttpClients.custom().setConnectionManager(cm).build();
	}

	/**
	 * 
	 * @param url
	 * @return
	 */
	public static String httpGetRequest(String url) {
		HttpGet httpGet = new HttpGet(url);
		return getResult(httpGet);
	}

	public static String httpGetRequest(String url, Map<String, Object> params) {
		try {
			URIBuilder ub = new URIBuilder();
			ub.setPath(url);

			ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
			ub.setParameters(pairs);

			HttpGet httpGet = new HttpGet(ub.build());
			return getResult(httpGet);
		} catch (Exception e) {
			logger.debug(ErrorType.Httpclient.toString(), e);
			throw new BaseException(ErrorType.Httpclient, e);
		}
	}

	public static String httpGetRequest(String url, Map<String, Object> headers, Map<String, Object> params) {
		try {
			URIBuilder ub = new URIBuilder();
			ub.setPath(url);

			ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
			ub.setParameters(pairs);

			HttpGet httpGet = new HttpGet(ub.build());
			for (Map.Entry<String, Object> param : headers.entrySet()) {
				httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));
			}
			return getResult(httpGet);
		} catch (Exception e) {
			logger.debug(ErrorType.Httpclient.toString(), e);
			throw new BaseException(ErrorType.Httpclient, e);
		}
	}

	public static String httpPostRequest(String url) {
		HttpPost httpPost = new HttpPost(url);
		return getResult(httpPost);
	}

	public static String httpPostRequest(String url, Map<String, Object> params) {
		try {
			HttpPost httpPost = new HttpPost(url);
			ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
			httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
			return getResult(httpPost);
		} catch (Exception e) {
			logger.debug(ErrorType.Httpclient.toString(), e);
			throw new BaseException(ErrorType.Httpclient, e);
		}
	}

	public static String httpPostRequest(String url, Map<String, Object> headers, Map<String, Object> params) {
		try {
			HttpPost httpPost = new HttpPost(url);

			for (Map.Entry<String, Object> param : headers.entrySet()) {
				httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
			}

			ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
			httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));

			return getResult(httpPost);
		} catch (Exception e) {
			logger.debug(ErrorType.Httpclient.toString(), e);
			throw new BaseException(ErrorType.Httpclient, e);
		}
	}

	private static ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
		ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			pairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
		}

		return pairs;
	}

	/**
	 * 处理Http请求
	 * 
	 * @param request
	 * @return
	 */
	private static String getResult(HttpRequestBase request) {
		CloseableHttpClient httpClient = getHttpClient();
		try {
			CloseableHttpResponse response = httpClient.execute(request);
			response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity);
				response.close();
				if (200 == response.getStatusLine().getStatusCode()) {
					return result;
				} else {
					throw new BaseException(ErrorType.Httpclient, result);
				}
			}
			return EMPTY_STR;
		} catch (Exception e) {
			logger.debug(ErrorType.Httpclient.toString(), e);
			throw new BaseException(ErrorType.Httpclient, e);
		} finally {

		}

	}
}
