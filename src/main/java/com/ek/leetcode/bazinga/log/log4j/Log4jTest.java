package com.ek.leetcode.bazinga.log.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Before;
import org.junit.Test;

/**
 * Personal
 * Created by snakeek on 2017/7/22.
 */
public class Log4jTest {
    private Logger logger;

    @Before
    public void init() {
        logger = Logger.getLogger(Log4jTest.class);
        logger.removeAllAppenders();
        logger.getRootLogger().removeAllAppenders();
    }

    @Test
    public void basicLogger() {
        BasicConfigurator.configure();
        logger.info("basicLogger");
    }

    @Test
    public void addAppenderWithStream() {
        logger.addAppender(new ConsoleAppender(new PatternLayout("%p %t %m%n"), ConsoleAppender.SYSTEM_OUT));
        logger.info("addAppenderWithStream");
    }

    @Test
    public void addAppenderWithoutStream() {
        logger.addAppender(new ConsoleAppender(new PatternLayout("%p %t %m%n")));
        logger.info("addAppenderWithoutStream");
    }
}
