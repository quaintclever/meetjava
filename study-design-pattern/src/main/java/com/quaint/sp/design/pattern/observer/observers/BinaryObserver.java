package com.quaint.sp.design.pattern.observer.observers;

import com.quaint.sp.design.pattern.observer.Subject;

/**
 * @Description:
 * @author: qicong
 * @Date: Created in 2019/9/16 20:01
 * @Version: 1.0
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
