package com.quaint.javabase.base;

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
        for (String s : city) {
            System.out.println(s);
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

//        forTest();

        for (String[] strings : cityCom) {
            System.out.println(arrayToString(strings));
        }
        System.out.println(cityCom[2][1]);


        System.out.println("==============================");
        for (String[] strings : cityCom) {
            for (int j = 0; j < cityCom[0].length; j++) {
                System.out.println(strings[j]);
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

    private static void forTest() {
        int[] arrTest = new int[500000000];
        int cnt = 0;
        long s1 = System.nanoTime();
        for (int i : arrTest) {
            cnt += i;
        }
        long s2 = System.nanoTime() - s1;

        long s11 = System.nanoTime();
        for (int i = 0; i < arrTest.length; i++) {
            cnt += arrTest[i];
        }
        long s22 = System.nanoTime() - s11;

        System.out.println("for in : " + s2 + "ns");
        System.out.println("for i : " + s22 + "ns");
        System.out.println("in - i: " + (s2 - s22) + "ns");
        System.out.println("in - i: " + (s2 - s22) / 1000000 + "ms");
    }


    private static void updateArray(String[][] cityCom) {
        cityCom[0][0] = "测试";
    }

    private static String arrayToString(Object[] arr) {
        if (arr == null) {
            return "null";
        }
        int iMax = arr.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; ; i++) {
            sb.append(arr[i]);
            if (i == iMax) {
                return sb.append(']').toString();
            }
            sb.append(", ");
        }
    }

}
