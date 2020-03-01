package com.quaint.design.pattern.absfactory;

import com.quaint.design.pattern.absfactory.color.Color;
import com.quaint.design.pattern.absfactory.shape.Shape;

/**
 * 抽象工厂
 * @author quaint
 * @date 2020-01-17 09:55
 */
public abstract class AbstractFactory {


    /**
     * 获取形状
     * @param type type
     * @return r
     */
    public abstract Shape getShape(String type);

    /**
     * 获取颜色
     * @param color color
     * @return r
     */
    public abstract Color getColor(String color);


}
