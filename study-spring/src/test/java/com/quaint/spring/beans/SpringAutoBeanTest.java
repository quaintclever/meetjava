package com.quaint.spring.beans;

import com.quaint.spring.beans.el.ELTestBean;
import com.quaint.spring.beans.el.ELTestBean2;
import com.quaint.spring.beans.primary.PrimaryTest;
import com.quaint.spring.config.BaseScanConfig;
import com.quaint.spring.service.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 20 June 2020
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BaseScanConfig.class)
public class SpringAutoBeanTest {

    @Autowired
    CompactDisc compactDisc;

    @Test
    public void annotationAutoBeanDI(){
        compactDisc.play();
    }

    @Autowired
//    @Qualifier("normalBean")
    PrimaryTest primaryTest;

    @Test
    public void primaryBeanTest(){
        primaryTest.sayHello();
    }


    @Autowired
    @Qualifier("elTest")
    ELTestBean elTestBean;

    @Test
    public void elTestBean(){
        elTestBean.sayHello();
    }

    @Autowired
    ELTestBean2 elTestBean2;

    @Test
    public void elTestBean2(){
        elTestBean2.sayHello();
    }

}
