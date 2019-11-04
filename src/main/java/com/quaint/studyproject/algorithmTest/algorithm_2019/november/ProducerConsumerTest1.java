package com.quaint.studyproject.algorithmTest.algorithm_2019.november;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: quaint
 * @Date: Created in 2019/11/4 15:20
 */
public class ProducerConsumerTest1 {

    public static final Integer MAX_SIZE = 10;

    private List<String> container = new ArrayList<>(MAX_SIZE);

    public void put(String str){
        this.container.add(str);
    }
    public int getSize(){
        return this.container.size();
    }
    public void push(){
        this.container.remove(0);
    }

    /**
     * 生产者 方法
     */
    synchronized void producerFun(){
        while (getSize()==MAX_SIZE){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        put("goods");
        System.out.println("生产了一个，目前库存"+getSize());
        notifyAll();
    }

    /**
     * 消费者 方法
     */
    synchronized void consumerFun(){
        while (getSize()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        push();
        System.out.println("消费了一个，目前库存"+getSize());
        notifyAll();
    }

    public static void main(String[] args) {

        ProducerConsumerTest1 producerConsumer = new ProducerConsumerTest1();
        // 创建 30 个生产者
        for (int i = 0; i < 30; i++) {
            new Thread(producerConsumer::producerFun).start();
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 创建 25 个消费者
        for (int i = 0; i < 25; i++) {
            new Thread(producerConsumer::consumerFun).start();
        }

    }

}
