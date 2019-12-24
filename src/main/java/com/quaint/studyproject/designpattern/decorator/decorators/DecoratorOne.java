package com.quaint.studyproject.designpattern.decorator.decorators;


import com.quaint.studyproject.designpattern.decorator.content.AbstractTea;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/10/4 14:40
 */
public class DecoratorOne extends Decorator {

    public DecoratorOne(AbstractTea abstractTea) {
        super(abstractTea);
        super.setPrice(1.0);
        super.setDesc("配料1，价格1元");
    }
}
