package com.ek.leetcode.bazinga.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/**
 * PersonalPractice
 * Created by snakeek on 2017/8/7.
 */
@Slf4j
public class HttpUtils {
    private final static int CONNECT_TIME_OUT = 5000;
    private final static int READ_TIME_OUT = 5000;

    public static String getHttpUrlContent(String urlStr, String encoding, boolean isPost, String postBody) {
        return getHttpUrlContent(urlStr, encoding, isPost, postBody, CONNECT_TIME_OUT, READ_TIME_OUT);
    }

    public static String getHttpUrlContent(String url) {
        return getHttpUrlContent(url, "UTF-8", false, null);
    }

    public static String getHttpUrlContent(String urlStr, String encoding, boolean isPost, String postBody, int connectTimeOut, int readTimeOut) {
        URL url = null;
        HttpURLConnection conn = null;
        long startTime = System.currentTimeMillis();
        try {
            url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            // post方法
            if (isPost) {
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            // 设置连接超时和读取超时两个时间，防止进程被憋住
            conn.setConnectTimeout(connectTimeOut);
            conn.setReadTimeout(readTimeOut);
            // 建立连接
            conn.connect();
            if (isPost) {
                OutputStream out = conn.getOutputStream();
                out.write(postBody.getBytes(encoding));
                out.flush();
            }
            InputStream is = null;
            try {
                is = conn.getInputStream();
            } catch (IOException ex) {
                log.error("conn getInputStream error : ", ex);
                is = conn.getErrorStream();
            }
            BufferedReader breader = new BufferedReader(new InputStreamReader(is, encoding));
            char[] c_buf = new char[8192];
            StringBuffer buf = new StringBuffer("");
            int len = breader.read(c_buf, 0, 8192);
            while (len > 0) {
                buf.append(c_buf, 0, len);
                c_buf = new char[8192];
                len = breader.read(c_buf, 0, 8192);
            }
            breader.close();
            return buf.toString();
        } catch (Exception e) {
            log.error("error in getHttpUrlContent " + urlStr, e);
        } finally {
            url = null;
            if (conn != null) {
                conn.disconnect();
            }
            long t = System.currentTimeMillis() - startTime;
            if (t > 300)
                log.warn(urlStr + " cost " + t);
        }
        return "";
    }

    public static String getHttpUrlContent(String urlStr, String encoding, boolean isPost, String postBody, Map<String, String> headers, int connectTimeOut, int readTimeOut) {
        URL url = null;
        HttpURLConnection conn = null;
        long startTime = System.currentTimeMillis();
        try {
            url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            Iterator iterator = headers.keySet().iterator();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                conn.setRequestProperty(key, headers.get(key));
            }
            // post方法
            if (isPost) {
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            // 设置连接超时和读取超时两个时间，防止进程被憋住
            conn.setConnectTimeout(connectTimeOut);
            conn.setReadTimeout(readTimeOut);
            // 建立连接
            conn.connect();
            if (isPost) {
                OutputStream out = conn.getOutputStream();
                out.write(postBody.getBytes(encoding));
                out.flush();
            }
            InputStream is = null;
            try {
                is = conn.getInputStream();
            } catch (IOException ex) {
                log.error("conn getInputStream error : ", ex);
                is = conn.getErrorStream();
            }
            BufferedReader breader = new BufferedReader(new InputStreamReader(is, encoding));
            char[] c_buf = new char[8192];
            StringBuffer buf = new StringBuffer("");
            int len = breader.read(c_buf, 0, 8192);
            while (len > 0) {
                buf.append(c_buf, 0, len);
                c_buf = new char[8192];
                len = breader.read(c_buf, 0, 8192);
            }
            breader.close();
            return buf.toString();
        } catch (Exception e) {
            log.error("error in getHttpUrlContent " + urlStr, e);
        } finally {
            url = null;
            if (conn != null) {
                conn.disconnect();
            }
            long t = System.currentTimeMillis() - startTime;
            if (t > 300)
                log.warn(urlStr + " cost " + t);
        }
        return "";
    }
}
