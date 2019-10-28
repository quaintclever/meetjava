package com.quaint.studyproject.demoTest.designPattern.decorator.content;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/10/7 20:50
 */
public class Tea extends AbstractTea {


    @Override
    public double showCost() {
        return super.getPrice();
    }

    @Override
    public String showDesc() {
        return super.getDesc();
    }
}
