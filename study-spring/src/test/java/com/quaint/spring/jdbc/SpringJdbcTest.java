package com.quaint.spring.jdbc;

import com.quaint.spring.helper.jdbc.DynamicDataSourceHolder;
import com.quaint.spring.mapper.DataBaseConnection;
import com.quaint.spring.po.SpringUserPo;
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
 * @since 17 June 2020
 */
public class SpringJdbcTest {

    /**
     * xml 配置多数据源 success
     */
    @Test
    public void dataBaseConnectionXmlTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans/knight.xml");
        DataBaseConnection dataBaseConnection = context.getBean(DataBaseConnection.class);
        DynamicDataSourceHolder.setDataSource("mysql2");
        SpringUserPo springUserPo = dataBaseConnection.selectById(2);
        System.out.println(springUserPo);
    }

    /**
     * 注解配置多数据源  未实现
     */
    @Test
    public void dataBaseConnectionAnnotationTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext("com.quaint.spring");
        DynamicDataSourceHolder.setDataSource("mysql1");
        DataBaseConnection dataBaseConnection = context.getBean(DataBaseConnection.class);
        SpringUserPo springUserPo = dataBaseConnection.selectById(1);
        System.out.println(springUserPo);
    }


}
