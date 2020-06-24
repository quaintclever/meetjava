package com.quaint.spring.beans.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 24 June 2020
 */
@Component
public class ELTestBean2 {

    @Value("${eltest.className}")
    private String className;

    public void sayHello(){
        System.out.println("======= ELTestBean =======");
        System.out.println(className);
        System.out.println("======= ELTestBean =======");
    }

}
