package com.quaint.spring.mvc;

import com.quaint.spring.config.mvc.RootConfig;
import com.quaint.spring.config.mvc.WebMvcConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 06 July 2020
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 指定 非 mvc 配置类
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }

    /**
     * 指定 mvc 配置类
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ WebMvcConfig.class };
    }

    /**
     * 将DispatcherServlet 映射到 /
     * @return s
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }


}
