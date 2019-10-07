package com.quaint.studyproject.designPattern.decorator.decorators;

import com.quaint.studyproject.designPattern.decorator.content.AbstractTea;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/10/4 14:41
 */
public class Decorator extends AbstractTea {

    private AbstractTea abstractTea;

    public Decorator(AbstractTea abstractTea) {
        this.abstractTea = abstractTea;
    }

    @Override
    public double showCost() {
        return abstractTea.showCost()+super.getPrice();
    }

    @Override
    public String showDesc() {
        return abstractTea.showDesc()+" || "+super.getDesc();
    }


}
