package com.quaint.design.pattern.single;

import java.util.concurrent.*;

/**
 * @author quaint
 * @date 2020-01-17 10:44
 */
public class SingleMainTest {

    public static void main(String[] args) throws Exception{

//        int num = 50;
//        ExecutorService exe = new ThreadPoolExecutor(50, num, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
//
//        CountDownLatch start = new CountDownLatch(1);
//        CountDownLatch end = new CountDownLatch(num);
//
//        for (int i = 0; i < num; i++) {
//            Worker worker = new Worker(i+1,start,end);
//            exe.execute(worker);
//        }
//        System.out.println("--开始执行--");
//        start.countDown();
//        end.await();
//        System.out.println("--执行结束--");
//        exe.shutdown();


        for (int i = 0; i < 100; i++) {
            new Thread(()->{
//                SingleEnum.getInstance().showMsg();
                SingleInnerClass.getInstance().showMsg();
//                SingleLazy.getInstance().showMsg();
//                SingleHungry.getInstance().showMsg();
//                SingleDCL.getInstance().showMsg();
            }).start();
        }

    }

    public static class Worker implements Runnable{

        private int i;
        private CountDownLatch start;
        private CountDownLatch end;

        public Worker(int i, CountDownLatch start, CountDownLatch end) {
            this.i = i;
            this.start = start;
            this.end = end;
        }


        @Override
        public void run() {

            try {
                System.out.println(i+"等待开始");
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SingleEnum.getInstance().showMsg();
//            SingleInnerClass.getInstance().showMsg();
//            SingleLazy.getInstance().showMsg();
//            SingleHungry.getInstance().showMsg();
//            SingleDCL.getInstance().showMsg();
            end.countDown();

        }
    }


}
