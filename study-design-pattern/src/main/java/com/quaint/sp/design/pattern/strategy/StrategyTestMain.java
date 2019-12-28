package com.quaint.sp.design.pattern.strategy;

/**
 * @Description:
 * @author: qicong
 * @Date: Created in 2019/9/16 11:48
 * @Version: 1.0
 */
public class StrategyTestMain {

    public static void main(String[] args) {

        Context context = new Context(new OperationAdd());
        System.out.println(context.execute(1,2));
        context.setStrategy(new OperationMultiply());
        System.out.println(context.execute(1,2));
        context.setStrategy(new OperationSubstract());
        System.out.println(context.execute(1,2));

    }

}
