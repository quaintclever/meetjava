package com.quaint.spring.beans.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 23 June 2020
 */
@Component
@Primary
public class PrimaryBean implements PrimaryTest{

    @Override
    public void sayHello(){
        System.out.println("PrimaryBean say hello");
    }

}
