package com.quaint.studyproject.smalltest;

import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.function.Consumer;

/**
 * description: 函数测试
 * @author qi cong
 * @date Created in 2019/10/12 15:39
 */
public class QuaintFunRecord {


    /**
     * list 转 str
     * @param list list
     * @return
     */
    public String listToStr(List list){

        if (CollectionUtils.isEmpty(list)){
            return "";
        }

        StringBuffer sb = new StringBuffer();
        list.forEach(o -> sb.append(o.toString()).append(" "));
        return sb.toString();
    }


    /**
     * 测试引用类型String 改变值
     * @param str string
     */
    public void listModify(String str){
        str+="testStr";
    }


    /**
     * 测试回调函数
     * @param type boolean
     * @param successCall 成功回调
     * @param failureCall 失败回调
     */
    public void testFun(boolean type, Consumer<Integer> successCall, Runnable failureCall){
        if (type){
            successCall.accept(1);
        }
        else{
            failureCall.run();
        }
        successCall.andThen(successCall);
    }

}
