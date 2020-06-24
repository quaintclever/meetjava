package com.quaint.spring.helper.converter;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.convert.support.DefaultConversionService;
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
public class SpringContextHolder implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 获取默认的 converter
        DefaultConversionService sharedInstance = (DefaultConversionService) DefaultConversionService.getSharedInstance();
        // 加入自定义 converter
        sharedInstance.addConverter(new StringELTestBeanConverter());
    }
}
