package com.quaint.spring.config;

import com.quaint.spring.service.Knight;
import com.quaint.spring.service.Quest;
import com.quaint.spring.service.impl.BraveKnight;
import com.quaint.spring.service.impl.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

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
    Knight getKnight(){
        return new BraveKnight(getQuest());
    }

    @Bean
    Quest getQuest(){
        return new SlayDragonQuest(System.out);
    }

//    @Bean
//    AnnotationMinstrel getMinstrel(){
//        return new AnnotationMinstrel();
//    }

}
