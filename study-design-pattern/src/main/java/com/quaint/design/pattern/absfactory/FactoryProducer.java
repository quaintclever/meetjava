package com.quaint.design.pattern.absfactory;

import com.quaint.design.pattern.absfactory.color.ColorFactory;
import com.quaint.design.pattern.absfactory.shape.ShapeFactory;

/**
 * @author quaint
 * @date 2020-01-17 10:04
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String type){

        if ("shape".equalsIgnoreCase(type)){
            return new ShapeFactory();
        } else if ("color".equalsIgnoreCase(type)){
            return new ColorFactory();
        }
        return null;
    }

}
