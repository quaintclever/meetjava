package com.quaint.studyproject.amusement.annotation.studyAnno;

import java.lang.reflect.Method;

/**
 * @Description: 测试含有Quaint注解的是否含有bug
 * @author: qi cong
 * @Date: Created in 2019/10/12 17:17
 */
public class QuaintTool {

    public static void main(String[] args) {

        NoBug noBug = new NoBug();
        Class clazz = noBug.getClass();
        Method[] method = clazz.getDeclaredMethods();
        //用来记录测试产生的 log 信息
        StringBuilder log = new StringBuilder();
        // 记录异常的次数
        int errornum = 0;
        for ( Method m: method ) {
            if ( m.isAnnotationPresent( Quaint.class )) {
                try {
                    m.setAccessible(true);
                    m.invoke(noBug, null);
                } catch (Exception e) {
                    //e.printStackTrace();
                    errornum++;
                    log.append(m.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n\r  caused by ");
                    //记录测试过程中，发生的异常的名称
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("-->");
                    //记录测试过程中，发生的异常的具体信息
                    log.append(e.getCause().getMessage());
                }
            }
        }
        log.append("\n\r[");
        log.append(clazz.getSimpleName());
        log.append("] has  ");
        log.append(errornum);
        log.append(" error.");
        // 生成测试报告
        System.out.println(log.toString());
    }

}
