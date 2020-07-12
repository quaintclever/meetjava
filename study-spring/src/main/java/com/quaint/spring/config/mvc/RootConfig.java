package com.quaint.spring.config.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * <p>
 * desc: 排除 开启mvc 的扫描
 * </p>
 *
 * @author quaint
 * @since 12 July 2020
 */
@Configuration
@ComponentScan(basePackages = {"com.quaint.spring"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {
}
