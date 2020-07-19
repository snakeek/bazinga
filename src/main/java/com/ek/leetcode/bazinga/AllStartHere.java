package com.ek.leetcode.bazinga;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AllStartHere {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date nowDate = calendar.getTime();
        Long nowIntDate = getLongByDate(nowDate, "yyyyMMdd") * 10000 + 2350;
        System.out.println(nowIntDate);
        System.out.println(turnStrToDate(nowIntDate + "", "yyyyMMddHHmm"));
    }

    public static Integer getIntByDate(Date date, String type) {
        String d = formatDate(date, type);
        return Integer.valueOf(d);
    }

    public static String formatDate(Date date, String type) {
        SimpleDateFormat format = new SimpleDateFormat(type);
        return format.format(date);
    }

    public static Long getLongByDate(Date date, String type) {
        String d = formatDate(date, type);
        return Long.parseLong(d);
    }

    public static Date turnStrToDate(String dateStr, String type) {
        SimpleDateFormat sdf = new SimpleDateFormat(type);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
