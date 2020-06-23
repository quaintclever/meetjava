package com.quaint.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * desc: 配置bean 扫描包路径
 * </p>
 *
 * @author quaint
 * @since 20 June 2020
 */
@Configuration
@ComponentScan(basePackages = "com.quaint.spring")
public class BaseScanConfig {
}
