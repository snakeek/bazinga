package com.ek.leetcode.bazinga.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * PersonalPractice
 * Created by snakeek on 2017/8/7.
 */
public enum BasicHttpClient {
    INSTANCE;
    private static Logger logger = LoggerFactory.getLogger(BasicHttpClient.class);

    private int connectionTimeout = 5000;
    private int socketReadTimeout = 5000;

    /**
     * 为了公用
     *
     * @param requestUrl
     * @param params     请求参数
     * @param authHeader 认证头信息.鉴权用.
     * @return
     * @throws Exception
     */
    public CloseableHttpResponse postRequest(String requestUrl, Map<String, String> params, String authHeader) throws Exception {

        List<NameValuePair> list = getParams(params);
        CloseableHttpClient httpClient = getHttpClient(authHeader);

        HttpPost httpPost = new HttpPost(requestUrl);
        httpPost.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
        httpPost.setConfig(getDefaultRequestConfig());
        final long callBefore = System.currentTimeMillis();
        CloseableHttpResponse response = httpClient.execute(httpPost,
                getHttpClientContext());
        logger.info("CALLURL【" + requestUrl + "】SPENDTIME【" + (System.currentTimeMillis() - callBefore) + "】毫秒");
        return response;
    }

    /**
     * 为了公用
     *
     * @param requestUrl
     * @param params     请求参数
     * @param authHeader 认证头信息.鉴权用.
     * @return
     * @throws Exception
     */
    public CloseableHttpResponse getRequest(String requestUrl, Map<String, String> params, String authHeader) throws Exception {

        CloseableHttpClient httpClient = getHttpClient(authHeader);

        HttpGet httpGet = new HttpGet(requestUrl);
        httpGet.setConfig(getDefaultRequestConfig());
        final long callBefore = System.currentTimeMillis();
        CloseableHttpResponse response = httpClient.execute(httpGet,
                getHttpClientContext());
        logger.info("CALLURL【" + requestUrl + "】SPENDTIME【" + (System.currentTimeMillis() - callBefore) + "】毫秒");
        return response;
    }


    private List<NameValuePair> getParams(Map<String, String> params) throws Exception {
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return list;
    }


    private HttpClientContext getHttpClientContext() {
        return HttpClientContext.create();
    }

    private RequestConfig getDefaultRequestConfig() {

        return RequestConfig.custom()
                .setSocketTimeout(socketReadTimeout)
                .setConnectTimeout(connectionTimeout)
                .build();
    }

    private CloseableHttpClient getHttpClient(String cookie) {
        Vector<BasicHeader> defaultHeaders = new Vector<>();
        defaultHeaders.add(new BasicHeader("Authorization", cookie));
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultHeaders(defaultHeaders)
                .setDefaultRequestConfig(getDefaultRequestConfig())
                .build();

        return httpClient;
    }
}
