package com.quaint.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * desc: 通过类配置 bean
 * </p>
 *
 * @author quaint
 * @since 16 June 2020
 */
@Configuration
@EnableAspectJAutoProxy
public class KnightConfig {


    @Bean
    public DynamicDataSource createDynamicDataSource(){
        DynamicDataSource dds = new DynamicDataSource();
        Map<Object,Object> dsMap = new HashMap<>(16);
        // 设置默认数据源
        dds.setDefaultTargetDataSource(createDataSource());
        // 添加多数据源
        dsMap.put("mysql1",createDataSource());
        dsMap.put("mysql2",createDataSource2());
        dds.setTargetDataSources(dsMap);
        return dds;
    }

    /**
     * 创建数据源对象
     * @return dataSource
     */
    @Bean(name="mysql1")
    public DataSource createDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/study_spring?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

    /**
     * 创建数据源对象
     * @return dataSource
     */
    @Bean(name="mysql2")
    public DataSource createDataSource2(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/study_spring2?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

}
