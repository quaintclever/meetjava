package com.quaint.spring.helper.converter;

import com.alibaba.fastjson.JSONObject;
import com.quaint.spring.beans.el.ELTestBean;
import org.springframework.core.convert.converter.Converter;

/**
 * <p>
 * desc: string 转换为 elTestBean
 * </p>
 *
 * @author quaint
 * @since 24 June 2020
 */
public class StringELTestBeanConverter implements Converter<String, ELTestBean> {


    @Override
    public ELTestBean convert(String source) {
        ELTestBean elTestBean = JSONObject.parseObject(source, ELTestBean.class);
        return elTestBean;
    }

}
