package com.quaint.sp.algorithm.year2020.month2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * @author quaint
 * @date 23 February 2020
 * @since 1.34
 */
public class LeetCodeTest {

    public static void main(String[] args) {

        int i = daysBetweenDates("2000-06-29", "2019-06-30");
        System.out.println(i);

    }


    public static int daysBetweenDates(String date1, String date2) {

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        Date d1 = null;
//        Date d2 = null;
//        try {
//            d1 = df.parse(date1);
//            d2 = df.parse(date2);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        Long tempDay = d1.getTime()/24/60/60/1000-d2.getTime()/24/60/60/1000;
//        int day = tempDay.intValue();
//
//        return day>0?day:day*-1;

        LocalDate local1 = LocalDate.parse(date1);
        LocalDate local2 = LocalDate.parse(date2);
        Long tempDay = local1.until(local2, ChronoUnit.DAYS);
        int day = tempDay.intValue();
        return day;
    }


    private static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                result[1] = i;
                result[0] = map.get(nums[i]);
                return result;
            }
            map.put(target-nums[i],i);
        }
        return result;
    }

}
