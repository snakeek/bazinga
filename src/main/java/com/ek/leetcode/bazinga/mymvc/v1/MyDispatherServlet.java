package com.ek.leetcode.bazinga.mymvc.v1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyDispatherServlet extends HttpServlet {

    private Properties contextConfig = new Properties();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //6.running
        doDispath(req, resp);
    }

    private void doDispath(HttpServletRequest req, HttpServletResponse resp) {
    }

    //init
    @Override
    public void init(ServletConfig config) throws ServletException {
        //1.load config
//        doLoadConfig(config.getInitParameter("contextConfigLocation"));
        //2.scan class
        doScanner();
        //3.init class and put in IOC container
        doInstance();
        //4.complate DI
        doAutoWired();
        //5.init HandlerMapping
        initHandlerMapping();

        System.out.println("My framework init complete！");
    }

    private void initHandlerMapping() {
    }

    private void doAutoWired() {
    }

    private void doInstance() {
    }

    private void doScanner() {
    }

//    private void doLoadConfig(String contextConfigLocation) {
//
//        InputStream stream = null;
//        stream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
//        try {
//            contextConfig.load(stream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (null != stream) {
//                try {
//                    stream.close();
//                } catch (IOException) {
//
//                }
//            }
//        }
//    }

}
