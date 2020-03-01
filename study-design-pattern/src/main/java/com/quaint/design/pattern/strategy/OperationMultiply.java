package com.quaint.design.pattern.strategy;

/**
 * @Description:
 * @author: qicong
 * @Date: Created in 2019/9/16 11:43
 * @Version: 1.0
 */
public class OperationMultiply implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        System.out.println("乘法策略执行...");
        return num1 * num2;
    }
}
