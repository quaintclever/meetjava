package com.quaint.spring.beans;

import com.quaint.spring.aop.AnnotationMinstrel;
import com.quaint.spring.service.Knight;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 16 June 2020
 */
public class SpringBeanTest {

    @Test
    public void xmlBeanTest(){
        // 获取上下文
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/knight.xml");
        // 通过 xml 获取 上下文中的 bean
        Knight knight = context.getBean(Knight.class);
        // 使用 bean
        knight.embarkOnQuest();
        context.close();
    }

    @Test
    public void annotationBeanTest(){
        // 通过 annotation 获取 上下文中的 bean
        ApplicationContext context = new AnnotationConfigApplicationContext("com.quaint.spring");
        // 通过 xml 获取 上下文中的 bean
        Knight knight = context.getBean(Knight.class);
        // 使用 bean
        knight.embarkOnQuest();
    }

}
