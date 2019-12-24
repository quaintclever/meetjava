package com.quaint.studyproject.designpattern.observer.observers;

import com.quaint.studyproject.designpattern.observer.Subject;

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
