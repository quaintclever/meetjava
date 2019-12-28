package com.quaint.sp.algorithm.year2019.sqrtTest;

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
            System.out.println(String.format("二分法第%d次循环，flag=%.10f",i,flag));
            i++;
        }
        return flag;
    }

    // 牛顿迭代法
    public static double getSqrt(double num){

        // f(x) = x^2-n;
        // 求 根，切线法接近
        // x1 处的切线方程为：  f(x) = k1x+b = k1x + (-x1^2-n);
        // ==> 切线与x交点  2xx1 + (-x1^2-n) = 0 ;
        // 焦点迭代公式  ==> x = (x1^2+n)/(2*x1)；
        // 结束条件  x*x - n < 1 * 10^-10;
        double x = num/2;
        int i = 1;
        while (x*x-num>0.000001 || x*x-num < -0.000001){
            x = (x*x+num)/(2*x);
            System.out.println("牛顿迭代法第"+i+"次结果："+x);
            i++;
        }
        return x;

    }

    public static void main(String[] args) {

        System.out.println("-------二分法结果：-------");
        System.out.println(getSqrt2());
        System.out.println("-------牛顿迭代法结果：-------");
        System.out.println(getSqrt(2));
        System.out.println("-------数学函数库结果：-------");
        System.out.println(Math.sqrt(2));

    }

}
