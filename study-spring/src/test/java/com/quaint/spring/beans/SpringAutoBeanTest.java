package com.quaint.spring.beans;

import com.quaint.spring.config.BaseScanConfig;
import com.quaint.spring.service.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

}
