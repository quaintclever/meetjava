package com.quaint.spring.test;

import com.quaint.spring.service.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 16 June 2020
 */
public class StudySpringMain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/beans/knight.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embrakOnQuest();
        context.close();

    }

}
