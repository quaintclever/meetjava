package com.quaint.other.code.quaint;

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
     * 只允许传入1个, 判断传入的是 o1 还是 o2
     * @param o1
     * @param o2
     * @return
     */
    protected static int judgeExportType(Object o1, Object o2){
        int type = 0;
        type += (o1 == null) ? 0 : 1;
        type += (o2 == null) ? 0 : 2;
        return type == 3 ? 0 : type;
    }

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
