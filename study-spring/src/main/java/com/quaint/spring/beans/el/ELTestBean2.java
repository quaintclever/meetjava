package com.quaint.spring.beans.el;

import lombok.Data;
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
@Data
public class ELTestBean2 {

    @Value("${eltest.className}")
    private String className;

    @Value("#{T(Math).PI + 'test'}")
    private String test;

    public void sayHello(){
        System.out.println("======= ELTestBean2 =======");
        System.out.println(className);
        System.out.println(test);
        System.out.println("======= ELTestBean2 =======");
    }

}
