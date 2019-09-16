package com.quaint.studyproject.designPattern.observer;

/**
 * @Description:
 * @author: qicong
 * @Date: Created in 2019/9/16 19:53
 * @Version: 1.0
 */
public abstract class Observer {

    protected Subject subject;

    abstract void update();

}
