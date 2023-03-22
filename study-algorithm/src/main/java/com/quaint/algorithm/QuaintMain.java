package com.quaint.algorithm;

import com.quaint.algorithm.abst.AbstractTest;
import com.quaint.algorithm.test.DpTest;

/**
 * <p>
 * desc: 启动类
 * </p>
 *
 * @author quaint
 * @since 18 April 2021
 */
public class QuaintMain {

    private static final AbstractTest dpTest = new DpTest();

    public static void main(String[] args) {
        // dpTest
        dpTest.execute();
    }

}