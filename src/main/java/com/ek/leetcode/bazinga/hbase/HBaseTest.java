package com.ek.leetcode.bazinga.hbase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

/**
 * Created by snakeek on 2018/9/26.
 */
public class HBaseTest {
    private static final String TABLE_NAME = "user_tag";

    private static final String ROW_KEY = "id";

    private static final String COLUMN_FAMILY = "userId";

    private static final String QUALIFIER = "jpush_1a1018970a80f9cd903";

    private static HbaseTemplate hbaseTemplate;

    public static void main(String[] args) {
        // 加载Spring配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        // 获取HbaseTemplate
        hbaseTemplate = (HbaseTemplate) applicationContext.getBean("hbaseTemplate");
        // 通过表名和rowKey获取最近一行数据
//        String result = hbaseTemplate.get(TABLE_NAME, ROW_KEY, new RowMapper<String>() {
//            public String mapRow(Result result, int rowNum) throws Exception {
//                return Bytes.toString(result.getValue(COLUMN_FAMILY.getBytes(), QUALIFIER.getBytes()));
//            }
//        });


    }
}