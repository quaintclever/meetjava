package com.quaint.javabase.juc;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author quaint
 * @since 06 April 2020
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        String[] shooters = {"鲁班","公孙离","狄仁杰","后羿","马可波罗"};
        String[] assassins = {"李白","娜可露露","孙悟空","赵云","韩信"};

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10,10,0, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(8), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 5; i++) {
            try {
                poolExecutor.execute(new Player(shooters[i],cyclicBarrier));
                TimeUnit.MILLISECONDS.sleep(1);
                poolExecutor.execute(new Player(assassins[i],cyclicBarrier));
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        poolExecutor.shutdown();


    }

    @Data
    static class Player implements Runnable{

        private String heroName;

        private CyclicBarrier cyclicBarrier;

        public Player(String heroName, CyclicBarrier cyclicBarrier) {
            this.heroName = heroName;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {

            Random random = new Random(System.currentTimeMillis());
            int schedule = 0;

            // 加载中
            try {
                for (int i = 0;; i++) {
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
                    schedule+= i * random.nextInt(25);
                    if (schedule>100){
                        System.out.println(heroName+"加载完成!");
                        break;
                    }
                    System.out.println(heroName+"-->加载中..."+schedule+"%");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 加载完成
            try {
                System.out.println(heroName+"加载完成... 等待其他玩家加载...");
                cyclicBarrier.await();
                System.out.println("所有玩家加载完成,通知["+heroName+"]可以进入比赛了");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

}
