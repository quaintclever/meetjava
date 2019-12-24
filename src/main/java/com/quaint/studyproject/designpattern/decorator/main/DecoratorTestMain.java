package com.quaint.studyproject.designpattern.decorator.main;

import com.quaint.studyproject.designpattern.decorator.content.AbstractTea;
import com.quaint.studyproject.designpattern.decorator.content.GreenTea;
import com.quaint.studyproject.designpattern.decorator.content.RedTea;
import com.quaint.studyproject.designpattern.decorator.decorators.DecoratorOne;
import com.quaint.studyproject.designpattern.decorator.decorators.DecoratorTwo;

/**
 * @Description: 装饰者模式测试 代码
 * @author: qi cong
 * @Date: Created in 2019/10/4 15:11
 */
public class DecoratorTestMain {

    public static void main(String[] args) {

        // 红茶增加两个配料
        AbstractTea redTea = new RedTea();
        redTea = new DecoratorOne(redTea);
        redTea = new DecoratorTwo(redTea);
        System.out.println("订单："+redTea.showDesc()+" \n价格："+redTea.showCost());

        // 绿茶不增加配料
        AbstractTea greenTea = new GreenTea();
        System.out.println("订单："+greenTea.showDesc()+" \n价格："+greenTea.showCost());

    }

}