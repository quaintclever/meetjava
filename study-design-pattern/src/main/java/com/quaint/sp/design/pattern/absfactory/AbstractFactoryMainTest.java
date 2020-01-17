package com.quaint.sp.design.pattern.absfactory;

import com.quaint.sp.design.pattern.absfactory.color.Color;
import com.quaint.sp.design.pattern.absfactory.shape.Shape;

/**
 * @author quaint
 * @date 2020-01-17 10:29
 */
public class AbstractFactoryMainTest {

    public static void main(String[] args) {

        AbstractFactory factory = FactoryProducer.getFactory("shape");
        Shape square = factory.getShape("square");
        factory = FactoryProducer.getFactory("color");
        Color color = factory.getColor("red");
        square.showShape();
        color.showColor();
    }

}
