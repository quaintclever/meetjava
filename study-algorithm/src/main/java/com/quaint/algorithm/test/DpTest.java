package com.quaint.algorithm.test;

import com.quaint.algorithm.abst.AbstractTest;
import com.quaint.algorithm.answer.DpAnswer;
import com.quaint.algorithm.classify.Dp;
import com.quaint.algorithm.util.LcDataProcessUtil;

import static com.quaint.algorithm.util.LcPrintUtil.printCompare;

/**
 * @author quaint
 * @since 2023/3/22 22:16
 */
public class DpTest extends AbstractTest {

    private static final DpAnswer answer = new DpAnswer();
    private static final Dp dp = new Dp();

    static {
        // 测试代码添加位置..
        ps.add(DpTest::trap);
    }

    private static String trap() {
        // case 1
        int[] arr1 = LcDataProcessUtil.get1dArr("[0,1,0,2,1,0,1,3,2,1,2,1]");
        printCompare(dp.trap(arr1), answer.trap(arr1));
        int[] arr2 = LcDataProcessUtil.get1dArr("[4,2,0,3,2,5]");
        printCompare(dp.trap(arr2), answer.trap(arr2));
        return "42. 接雨水";
    }

}
