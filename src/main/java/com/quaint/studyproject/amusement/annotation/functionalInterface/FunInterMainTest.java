package com.quaint.studyproject.amusement.annotation.functionalInterface;

import java.text.MessageFormat;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/10/12 17:40
 */
public class FunInterMainTest {

    public static void main(String[] args) {

        // 函数编程 lambda直接实现
        FunctionalInterfaceTest lambdaImpl = (a,b) ->{
            System.out.println(MessageFormat.format("lambdaImpl -> {1}+{0}的结果为{2}",
                    a,b,a+b));
        };
        lambdaImpl.quaintFunTest(1,2);

        // lambda 练习
        FunctionalInterfaceTest lambdaTest = (a,b) -> FunctionalInterfaceTest.addTest(a,b);
        lambdaTest.quaintFunTest(3,4);

        // 方法引用 练习
        FunctionalInterfaceTest funQuoteTest = FunctionalInterfaceTest::addTest;
        funQuoteTest.quaintFunTest(5,6);

    }


}
