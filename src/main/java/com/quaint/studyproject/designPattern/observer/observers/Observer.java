package com.quaint.studyproject.designPattern.observer.observers;

import com.quaint.studyproject.designPattern.observer.Subject;

/**
 * @Description:
 * @author: qicong
 * @Date: Created in 2019/9/16 19:53
 * @Version: 1.0
 */
public abstract class Observer {

    Subject subject;

    public abstract void update();

}
