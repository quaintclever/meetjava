package com.quaint.studyproject.demoTest.sync;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/10/25 19:04
 */
public class Test03 extends Thread{

    int count = 10;

    @Override
//    public void run() { 可能出现 95887 等结果
    public synchronized void run() { // 98765
        super.run();
        count--;
        System.out.println(count);
    }

    public static void main(String[] args) {

        Test03 test03 = new Test03();
        for (int i = 0 ;i < 5;i++){
            new Thread(test03,"thread"+i).start();
        }

    }

}
