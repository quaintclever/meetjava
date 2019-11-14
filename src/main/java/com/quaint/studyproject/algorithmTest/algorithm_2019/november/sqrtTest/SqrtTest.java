package com.quaint.studyproject.algorithmTest.algorithm_2019.november.sqrtTest;

/**
 * @Description: sqrt(2) 精确 10位
 * @author: qi cong
 * @Date: Created in 2019-11-13 16:40
 */
public class SqrtTest {


    // 二分法
    public static double getSqrt2(){

        double height = 1.5;
        double low = 1.4;
        double flag = (height+low)/2;
        int i = 1;
        // 精确到 小数点 后十位
        while (height-low>0.00000000001){
            height = flag*flag>2?flag:height;
            low = flag*flag<2?flag:low;
            flag = (height+low)/2;
            System.out.println(String.format("第%d次循环，flag=%.10f",i,flag));
            i++;
        }
        return flag;
    }

    public static void main(String[] args) {

        System.out.println(getSqrt2());
        System.out.println(Math.sqrt(2));

    }

}
