package com.quaint.studyproject.test;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * @Description: String 调试测试
 * @author: qicong
 * @Date: Created in 2019/9/19 11:28
 * @Version: 1.0
 */
public class QuaintTestRecord {

    public static void main(String[] args) {



//        // 打印出map的key     2019/10/22
//        Map map = new HashMap();
//        map.put("test1",5L);
//        System.out.println(map.keySet().toArray()[0]);


//        // 获取每月的 第一天和最后一天  2019/10/18
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime startTime = now.with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0);
//        LocalDateTime endTime = now.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59);
//        System.out.println(startTime);
//        System.out.println(endTime);


//        // 测试 BigDecimal 的比较方法   2019/10/17
//        BigDecimal bigDecimal = new BigDecimal(1).multiply(new BigDecimal(0.05));
//        System.out.println(bigDecimal);
//        System.out.println(BigDecimal.ZERO.equals(bigDecimal));
//        System.out.println("0.00".equals(bigDecimal.toString()));
//        System.out.println(BigDecimal.ZERO.compareTo(bigDecimal));


//        // LocalDateTime 与字符串转换测试  2019/10/17
//        System.out.println(LocalDateTime.parse("2017-11-11T11:11:00"));
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        System.out.println(LocalDateTime.parse("2017-11-11 11:11:11",df));
//        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        System.out.println(LocalDate.parse("2017-11-11"));
//        System.out.println(LocalDate.parse("2017-11-11",df2).atTime(0,0,0));
//        System.out.println(LocalDate.parse("2017-11-11",df2).atTime(23,59,59));
//        System.out.println(LocalDateTime.now().toString().replace('T',' '));
//        System.out.println(LocalDateTime.now().withHour(0).withMinute(0).withSecond(0));


//        // float 类型精度问题 2019/10/17
//        Float confirmedRefundMoney = 0.7f;
//        int refundRemainderInCent = 70;
//        String wx = String.format("%.2f",Math.abs(confirmedRefundMoney - refundRemainderInCent/100.0));
//        String wx2 = String.format("%.2f",confirmedRefundMoney - refundRemainderInCent/100.0);
//        System.out.println(wx+"  "+wx2);

    }

}
