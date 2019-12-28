package com.quaint.sp.design.pattern.strategy;


/**
 * @Description:
 * @author: qicong
 * @Date: Created in 2019/9/16 11:42
 * @Version: 1.0
 */
public class OperationSubstract implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        System.out.println("减法策略执行...");
        return num1-num2;
    }
}
