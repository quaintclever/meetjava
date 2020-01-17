package com.quaint.sp.design.pattern.absfactory.color;

import com.quaint.sp.design.pattern.absfactory.AbstractFactory;
import com.quaint.sp.design.pattern.absfactory.shape.Shape;

/**
 * @author quaint
 * @date 2020-01-17 10:27
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String type) {
        return null;
    }

    @Override
    public Color getColor(String color) {

        if ("red".equalsIgnoreCase(color)) {
            return new RedColor();
        } else if ("blue".equalsIgnoreCase(color)) {
            return new BlueColor();
        }
        return null;
    }
}
