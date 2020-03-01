package com.quaint.design.pattern.decorator.content;


/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/10/4 14:51
 */
public abstract class AbstractTea {

    private double price;
    private String desc;

    /**
     * 展示价格
     */
    public abstract double showCost();

    /**
     * 展示描述
     */
    public abstract String showDesc();


    protected double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    protected String getDesc() {
        return desc;
    }

    protected void setDesc(String desc) {
        this.desc = desc;
    }
}
