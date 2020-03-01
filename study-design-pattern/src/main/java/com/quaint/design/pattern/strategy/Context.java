package com.quaint.design.pattern.strategy;

/**
 * @Description:
 * @author: qicong
 * @Date: Created in 2019/9/16 11:45
 * @Version: 1.0
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int num1, int num2){
        return strategy.doOperation(num1,num2);
    }

}
