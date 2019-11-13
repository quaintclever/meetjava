package com.quaint.studyproject.algorithmTest.algorithm_2019.november.producerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @author: quaint
 * @Date: Created in 2019/11/4 16:19
 */
public class ProducerConsumerTest2 {

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

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    /**
     * 生产者 方法
     */
    void producerFun(){

        lock.lock();
        while (getSize()==MAX_SIZE){
            try {
                producer.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        put("goods");
        System.out.println("生产了一个，目前库存"+getSize());
        consumer.signalAll();
    }

    /**
     * 消费者 方法
     */
    synchronized void consumerFun(){
        lock.lock();
        while (getSize()==0){
            try {
                consumer.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        push();
        System.out.println("消费了一个，目前库存"+getSize());
        producer.signalAll();
    }


    public static void main(String[] args) {

        ProducerConsumerTest1 producerConsumer = new ProducerConsumerTest1();
        // 创建 30 个生产者
        for (int i = 0; i < 20; i++) {
            new Thread(producerConsumer::producerFun).start();
        }
        // 先生产 达到上限
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 创建 25 个消费者
        for (int i = 0; i < 15; i++) {
            new Thread(producerConsumer::consumerFun).start();
        }

    }

}
