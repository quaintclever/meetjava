package com.quaint.spring.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

/**
 * <p>
 * desc: 吟唱诗人 annotation aop
 * </p>
 *
 * @author quaint
 * @since 16 June 2020
 */
@Aspect
@Component
public class AnnotationMinstrel {

    @Value("#{T(System).out}")
    private PrintStream stream;

    @Pointcut("execution(* *.embarkOnQuest(..))")
    public void pointcut(){}

    @Before(value = "pointcut()")
    public void singBeforeQuest(){
        stream.println("吟唱诗人: 英勇的屠龙勇士啊~~");
    }

    @After("pointcut()")
    public void singAfterQuest(){
        stream.println("吟唱诗人: 我歌唱你, 赞美你~~");
    }



}
