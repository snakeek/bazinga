package com.ek.leetcode.bazinga.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * check utils
 * Created by snakeek on 2018/8/31.
 */
public class RegexUtil {
    public static void main(String[] args) {
        System.out.println(isMatch(REG_INTEGER, "-9.0"));

        System.out.println(matchNum("1212|2323|1212", "1212"));
    }

    /**
     * 非负整数（正整数 + 0）
     */
    public static final String REG_INTEGER_NON_NEGATIVE = "^\\d+$";
    public static final String REG_INTEGER_POSITIVE = "^[0-9]*[1-9][0-9]*$";//正整数
    public static final String REG_INTEGER_NON_POSITIVE = "^((-\\d+)|(0+))$";//非正整数（负整数 + 0）
    public static final String REG_INTEGER_NEGATIVE = "^-[0-9]*[1-9][0-9]*$";//负整数
    public static final String REG_INTEGER = "^-?\\d+$";//整数
    public static final String REG_FLOAT_NON_NEGATIVE = "^\\d+(\\.\\d+)?$";//非负浮点数（正浮点数 + 0）
    public static final String REG_FLOAT_POSITIVE = "^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$";//正浮点数
    public static final String REG_FLOAT_NON_POSITIVE = "^((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$";//非正浮点数（负浮点数 + 0）
    public static final String REG_FLOAT_NEGATIVE = "^(-(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*)))$";//负浮点数
    public static final String REG_FLOAT = "^(-?\\d+)(\\.\\d+)?$";//浮点数
    public static final String REG_ENGLISH = "^[A-Za-z]+$";//由26个英文字母组成的字符串
    public static final String REG_ENGLISH_UPPER = "^[A-Z]+$";//由26个英文字母的大写组成的字符串
    public static final String REG_ENGLISH_LOWER = "^[a-z]+$";//由26个英文字母的小写组成的字符串
    public static final String REG_ENGLISH_NUMBER = "^[A-Za-z0-9]+$";//由数字和26个英文字母组成的字符串
    public static final String REG_ENGLISH_WORD = "^\\w+$";//由数字、26个英文字母或者下划线组成的字符串
    public static final String REG_EMAIL = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";//email地址
    public static final String REG_PHONE = "(\\d+-)?(\\d{4}-?\\d{7,8}|\\d{3}-?\\d{7,8}|^\\d{7,8})(-\\d+)?"; //电话号码
    public static final String REG_MOBILE_PHONE = "^((\\+86)?|\\(\\+86\\))0?1[35689]\\d{9}$";//手机号码
    public static final String REG_ACCOUNT = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";//匹配帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)
    public static final String REG_ID_CART = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";//身份证号码
    public static final String REG_IPV4_ADDRESS = "^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5]).(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5]).(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5]).(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])$"; //IP地址
    public static final String REG_IPV6_BASIC = "^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}$";
    public static final String REG_IPV6_SHOR = "^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}$|^:((:[\\da-fA-F]{1,4}){1,6}|:)$|^[\\da-fA-F]{1,4}:((:[\\da-fA-F]{1,4}){1,5}|:)$|^([\\da-fA-F]{1,4}:){2}((:[\\da-fA-F]{1,4}){1,4}|:)$|^([\\da-fA-F]{1,4}:){3}((:[\\da-fA-F]{1,4}){1,3}|:)$|^([\\da-fA-F]{1,4}:){4}((:[\\da-fA-F]{1,4}){1,2}|:)$|^([\\da-fA-F]{1,4}:){5}:([\\da-fA-F]{1,4})?$|^([\\da-fA-F]{1,4}:){6}:$";
    public static final String REG_IPV6_ADDRESS = "^([\\da-fA-F]{1,4}:){6}((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$|^::([\\da-fA-F]{1,4}:){0,4}((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$|^([\\da-fA-F]{1,4}:):([\\da-fA-F]{1,4}:){0,3}((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$|^([\\da-fA-F]{1,4}:){2}:([\\da-fA-F]{1,4}:){0,2}((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$|^([\\da-fA-F]{1,4}:){3}:([\\da-fA-F]{1,4}:){0,1}((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$|^([\\da-fA-F]{1,4}:){4}:((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$|^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}$|^:((:[\\da-fA-F]{1,4}){1,6}|:)$|^[\\da-fA-F]{1,4}:((:[\\da-fA-F]{1,4}){1,5}|:)$|^([\\da-fA-F]{1,4}:){2}((:[\\da-fA-F]{1,4}){1,4}|:)$|^([\\da-fA-F]{1,4}:){3}((:[\\da-fA-F]{1,4}){1,3}|:)$|^([\\da-fA-F]{1,4}:){4}((:[\\da-fA-F]{1,4}){1,2}|:)$|^([\\da-fA-F]{1,4}:){5}:([\\da-fA-F]{1,4})?$|^([\\da-fA-F]{1,4}:){6}:$";
    public static final String REG_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%#&=]*)?";//url
    public static final String REG_BIRTHDAY = "^(\\d){4}/(\\d){1,2}/(\\d){1,2}$";//检查手机号码

    /**
     * 查看是否匹配
     *
     * @param reg    正则表达式
     * @param source 匹配的数据
     * @return
     */
    public static boolean isMatch(String reg, String source) {
        Pattern p = Pattern.compile(reg);
        Matcher matcher = p.matcher(source);
        return matcher.matches();
    }

    /**
     * 查看匹配次数
     *
     * @param reg
     * @param source
     * @return
     */
    public static int matchNum(String reg, String source) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(source);
        int i = 0;
        while (m.find()) {
            // m.group();
            i++;
        }
        return i;
    }

    public static boolean isEmail(String email) {
        return !StringUtils.isEmpty(email) && isMatch(REG_EMAIL, email);
    }

    public static boolean isTel(String mobile) {
        return !StringUtils.isEmpty(mobile) && isMatch(REG_MOBILE_PHONE, mobile);
    }

    public static boolean isBirthday(String birthday) {
        return !StringUtils.isEmpty(birthday) && isMatch(REG_BIRTHDAY, birthday);
    }

}
