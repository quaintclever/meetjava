package com.quaint.spring.helper.active;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 22 June 2020
 */
public class ActiveQuaintBeanCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String[] activeProfiles = environment.getActiveProfiles();
        if (activeProfiles.length==0){
            return false;
        }
        return "quaint".equals(activeProfiles[0]);
    }
}
