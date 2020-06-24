package com.quaint.spring.beans.el;

import com.quaint.spring.config.el.ELBeanTestConfig;
import lombok.Data;

/**
 * <p>
 * desc: 通过配置 动态注入 bean
 * </p>
 *
 * @author quaint
 * @since 23 June 2020
 * @see ELBeanTestConfig
 */
@Data
public class ELTestBean {

    private String className;
    private String test;

    public void sayHello(){
        System.out.println("======= ELTestBean =======");
        System.out.println(className);
        System.out.println("======= ELTestBean =======");
    }
}
