package com.quaint.spring.config.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 12 July 2020
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {


    /**
     * 配置视图解析器
     * @return vr
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/resources/views/");
        resolver.setSuffix(".html");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * 配置静态资源的处理
     * @param configurer configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 我们要求DispatcherServlet将对静态资源的请求转发到Servlet容器 中默认的Servlet上
        // 而不是使用DispatcherServlet本身来处理此类请求。
        configurer.enable();
    }
}
