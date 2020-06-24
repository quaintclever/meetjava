package com.quaint.spring.beans.active;

import com.quaint.spring.helper.active.ActiveQuaintBeanCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * <p>
 * desc: 测试 @Conditional
 * </p>
 *
 * @author quaint
 * @since 22 June 2020
 */
@Component
@Conditional(ActiveQuaintBeanCondition.class)
public class ActiveQuaintBean {

    public void activeSayHello(){
        System.out.println("active say : hello world!");
    }

}
