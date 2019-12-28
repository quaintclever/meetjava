package com.quaint.sp.design.pattern.observer.main;

import com.quaint.sp.design.pattern.observer.Subject;
import com.quaint.sp.design.pattern.observer.observers.BinaryObserver;
import com.quaint.sp.design.pattern.observer.observers.HexaObserver;
import com.quaint.sp.design.pattern.observer.observers.OctalObserver;

/**
 * @Description: 观察者模式测试代码
 * @author: qicong
 * @Date: Created in 2019/9/16 20:04
 * @Version: 1.0
 */
public class ObserverTestMain {

    public static void main(String[] args) {

        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);

    }

}
