package com.quaint.sp.design.pattern.observer;

import com.quaint.sp.design.pattern.observer.observers.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 观察者模式主题
 * @author: qicong
 * @Date: Created in 2019/9/16 19:52
 * @Version: 1.0
 */
public class Subject {

    // 观察者集合
    private List<Observer> observers = new ArrayList<>();
    // 状态值
    private int state;

    /**
     * 通知所有观察者
     * @param observers
     */
    public void notifyAllObservers(List<Observer> observers){
        observers.forEach(observer -> {
            observer.update();
        });
    }

    /**
     * 添加观察者
     * @param observer
     */
    public void attach(Observer observer){
        this.observers.add(observer);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        // 发送通知
        notifyAllObservers(observers);
    }
}
