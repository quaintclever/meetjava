package com.quaint.studyproject.designpattern.decorator.decorators;

import com.quaint.studyproject.designpattern.decorator.content.AbstractTea;


/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/10/4 14:40
 */
public class DecoratorTwo extends Decorator {

    public DecoratorTwo(AbstractTea abstractTea) {
        super(abstractTea);
        super.setPrice(2.0);
        super.setDesc("配料2，价格2元");
    }
}
