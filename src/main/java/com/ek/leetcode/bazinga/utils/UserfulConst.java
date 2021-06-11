package com.ek.leetcode.bazinga.utils;

import java.util.regex.Pattern;

/**
 * PersonalPractice
 * Created by snakeek on 2017/8/9.
 */
public class UserfulConst {
    public static final String DDETOP30 = "http://www.iwencai.com/stockpick/search?ts=1&tid=stockpick&qs=lm_hqzb_a&w=DDE大单净量前30";
    public static final String DDE3DAY = "http://www.iwencai.com/stockpick/search?typed=1&preParams=&ts=2&f=1&qs=result_rewrite&selfsectsn=&querytype=&searchfilter=&tid=stockpick&w=DDE连续三日大于0";
    public static final Pattern LABEL_CONTENT = Pattern.compile("(?<=>)([^<>]+?)(?=<)");
    public static final Pattern HREF_LINK = Pattern.compile("href=\"([^\"]*)\"");
    public static final Pattern DIGIGT_DOT_NEGETIVE = Pattern.compile("[\\-0-9%\\.]+");//匹配出数字,小数点,正负号.
    public static final Pattern STOCK_CODE = Pattern.compile("[0-9]{6}");//
}
