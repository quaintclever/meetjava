package com.quaint.studyproject.designpattern.decorator.content;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/10/4 15:08
 */
public class GreenTea extends Tea{

    public GreenTea() {
        super.setPrice(3.0);
        super.setDesc("绿茶3元一瓶");
    }
}
