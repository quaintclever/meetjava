package com.quaint.javabase.base;

import java.util.Arrays;

/**
 * @author quaint
 * @date 2021/3/30
 */
public class BaseArrayTest {

    public static void main(String[] args) {
        // 定义一个长度为3元素类型为int的数组a
        int a[] = new int[3];
        int[] b = new int[3];
        System.out.println(a.length);
        System.out.println(b.length);

        String[] city = {"北京", "上海", "深圳"};
        // 方法1：for循环遍历
        for (int i = 0; i < city.length; i++) {
            System.out.println(city[i]);
        }
        // 方法2：for range遍历
        for (String c : city) {
            System.out.println(c);
        }

        String[][] cityCom = {
                {"北京", "上海"},
                {"广州", "深圳"},
                {"成都", "重庆"},
        };
        for (int i = 0; i < cityCom.length; i++) {
            System.out.println(Arrays.toString(cityCom[i]));
        }
        System.out.println(cityCom[2][1]);


        System.out.println("==============================");
        for (int i = 0; i < cityCom.length; i++) {
            for (int j = 0; j < cityCom[0].length; j++) {
                System.out.println(cityCom[i][j]);
            }
        }
        System.out.println("==============================");
        for (String[] cc : cityCom) {
            for (String c : cc) {
                System.out.println(c);
            }
        }

        System.out.println("==============================");
        System.out.println(cityCom[0][0]);
        updateArray(cityCom);
        System.out.println(cityCom[0][0]);
    }

    private static void updateArray(String[][] cityCom) {
        cityCom[0][0] = "测试";
    }

}
