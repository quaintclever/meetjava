package com.quaint.spring.beans.el;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class ELTestBean3 {

    @Value("#{ELTestBean2}")
    private ELTestBean2 elTestBean2;

    @Value("#{ELTestBean2.className}")
    private String className;

    @Value("#{ELTestBean2.test}")
    private String test;

    public void sayHello(){
        elTestBean2.sayHello();
        System.out.println("======= ELTestBean3 =======");
        System.out.println(className);
        System.out.println(test);
//        System.out.println(elTestBean2);
        System.out.println("======= ELTestBean3 =======");
    }

}
