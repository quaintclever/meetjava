package com.quaint.studyproject.smallTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/10/17 14:09
 */
public class TempTest {

    public static void main(String[] args) {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = "2017-08-25 00:00:00";

        System.out.println(LocalDateTime.parse(time,df));

    }

}
