package com.quaint.studyproject.demoTest.annotation.functionalInterface;

import java.text.MessageFormat;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/10/12 17:31
 */
@FunctionalInterface
public interface FunctionalInterfaceTest {

    void quaintFunTest(int a, int b);

    static void addTest(int a, int b){
        System.out.println(MessageFormat.format("{1}+{0}的结果为{2}",
                a,b,a+b));
    }

}
