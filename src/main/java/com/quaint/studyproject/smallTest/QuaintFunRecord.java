package com.quaint.studyproject.smallTest;

import java.util.function.Consumer;

/**
 * @Description: 成功，失败，回调函数测试
 * @author: qi cong
 * @Date: Created in 2019/10/12 15:39
 */
public class QuaintFunRecord {


    // 测试引用类型 改变值
    public void listModify(String str){
        str+="test";
    }


    /**
     * 测试回调函数
     * @param type
     * @param successCall
     * @param failureCall
     */
    public void testFun(boolean type, Consumer<Integer> successCall, Runnable failureCall){
        if (type)
            successCall.accept(1);
        else
            failureCall.run();
        successCall.andThen(successCall);
    }

}
