package com.quaint.studyproject.designPattern.observer;

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
    void update() {
        System.out.println( "Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
