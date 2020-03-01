package com.quaint.design.pattern.strategy;

/**
 * @Description:
 * @author: qicong
 * @Date: Created in 2019/9/16 11:39
 * @Version: 1.0
 */
public class OperationAdd implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        System.out.println("加法策略执行...");
        return num1+num2;
    }
}
