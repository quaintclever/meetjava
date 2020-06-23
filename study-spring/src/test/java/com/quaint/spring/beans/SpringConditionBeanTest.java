package com.quaint.spring.beans;

import com.quaint.spring.config.BaseScanConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 22 June 2020
 */
@ContextConfiguration(classes = BaseScanConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("quaint")
public class SpringConditionBeanTest {

    @Autowired
    ActiveQuaintBean activeQuaintBean;

    @Test
    public void conditionBeanTest(){
        activeQuaintBean.activeSayHello();
    }

}
