package com.quaint.algorithm.abst;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * desc: 抽象test
 * </p>
 *
 * @author quaint
 * @since 18 April 2021
 */
public abstract class AbstractTest {

    protected static List<Processor> ps = new ArrayList<>();

    public void execute() {
        ps.forEach(p -> {
            System.out.println("=====================");
            System.out.println("测试开始执行");
            String name = p.process();
            System.out.println("【" + name + "】执行完毕");
            System.out.println("=====================");
        });
    }

    /**
     * 常用测试变量定义
     */
    protected static int[] arr1d1 = {};
    protected static int[] arr1d2 = {};
    protected static int[][] arr2d1 = {{}};
    protected static int[][] arr2d2 = {{}};

}