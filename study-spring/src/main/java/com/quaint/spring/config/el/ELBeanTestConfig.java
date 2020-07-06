package com.quaint.spring.config.el;

import com.quaint.spring.beans.el.ELTestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 23 June 2020
 */
@Configuration
@PropertySource("app.properties")
public class ELBeanTestConfig {

    @Autowired
    Environment environment;

    @Bean
    @Primary
    ELTestBean loadELTestBean(){
        ELTestBean elTestBean = new ELTestBean();
        elTestBean.setClassName(environment.getProperty("eltest.className"));
        elTestBean.setTest(environment.getProperty("eltest.test"));
        return elTestBean;
    }

    @Bean
    ELTestBean loadELTestBean2(){
        // 基础属性  e.g. int String double float ... and so on.
        // this is return null.
        // 如果增加对应转换器. 则可以不返回空
        ELTestBean elTestBean = environment.getProperty("eltest",ELTestBean.class);
        return elTestBean;
    }

}
