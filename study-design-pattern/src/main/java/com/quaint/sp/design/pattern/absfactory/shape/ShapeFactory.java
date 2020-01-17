package com.quaint.sp.design.pattern.absfactory.shape;

import com.quaint.sp.design.pattern.absfactory.AbstractFactory;
import com.quaint.sp.design.pattern.absfactory.color.Color;

/**
 * @author quaint
 * @date 2020-01-17 09:57
 */
public class ShapeFactory extends AbstractFactory {


    @Override
    public Shape getShape(String type) {

        if ("square".equalsIgnoreCase(type)){
            return new Square();
        } else if ("triangle".equalsIgnoreCase(type)){
            return new Triangle();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
