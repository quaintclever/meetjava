package com.quaint.spring.config.jdbc;

import com.quaint.spring.helper.jdbc.DynamicDataSourceHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <p>
 * desc: 动态数据源配置
 * </p>
 *
 * @author quaint
 * @since 17 June 2020
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        // 从自定义的位置获取数据源标识
        return DynamicDataSourceHolder.getDataSource();
    }
}
