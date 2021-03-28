package com.quaint.algorithm.year2021.january;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p>
 * desc: 里程计算
 *
 * 1. 两个信号a,b
 * 2. 每个信号 有值和时间
 * 3. 根据一个信号的值，统计另一个信号对应值 持续时间
 * 	- a -> range(0.06, n, 0.1), random()
 * 	- b -> range(0.1, n, 0.1), random()
 *
 * </p>
 *
 * @author quaint
 * @since 29 January 2021
 */
public class MileageCalc {


    public static void main(String[] args) {


        int n = 30000;

        double [][] a = new double[n][2];
        double [][] b = new double[n][2];
        Random ran = new Random(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            a[i][0] = 0.1 * i + ran.nextDouble();
            a[i][1] = ran.nextInt(10);

        }
        for (int i=0;i<5000;i++){
            b[i][0] = 0.6 * i + ran.nextDouble();
            b[i][1] = ran.nextDouble() + ran.nextInt(999);
        }

        AtomicReference<Double> ar = new AtomicReference<>(0.0);
        exec(a,b).forEach((k,v) -> {
            ar.getAndSet(ar.get() + v);
            System.out.println("key: => " +k+ " val: => " + v);
        });
        System.out.println("===> sum ans: "+ ar.get());

        double bAns = 0;
        double[] leftB = b[0];
        for (double[] bd :b) {
            if (leftB[0] == bd[0]) {
                continue;
            }
            bAns += (bd[0] - leftB[0]) * bd[1];
            leftB = bd;
        }
        System.out.println("===> sum b: "+ bAns);

    }


    private static Map<Integer,Double> exec(double[][] a, double[][] b) {
        Map<Integer,Double> res = new HashMap<>(16);
        int ai = 1;
        int bi = 0;
        double[] leftB = new double[2];
        double[] leftA = a[0];
        while (ai < a.length) {
            while (bi < b.length && b[bi][0] < a[ai][0]) {
                leftB = b[bi];
                bi += 1;
            }
            if (bi == b.length) {
                break;
            }

            // 计算速度
            double diff = diff(leftB, b[bi], a[ai][0]);
            // 存储距离
            double distance = (a[ai][0] - leftA[0]) * diff;
//            System.out.println("diff: "+diff + "\tdistance: " + distance);

            // 累加
            int av = (int)a[ai][1];
            if (res.containsKey(av)){
                res.put(av,res.get(av) + distance);
            } else {
                res.put(av,distance);
            }

            // 进行下次迭代
            leftA = a[ai];
            ai ++;
        }
        return res;
    }

    /**
     * 线性 差值计算
     * @param lb left b 信号  (时间, 信号值)
     * @param rb right b 信号  (时间, 信号值)
     * @param t 目标时刻
     * @return t 时刻的速度
     */
    private static double diff(double[] lb, double[] rb, double t) {
//        System.out.println("lb:" + Arrays.toString(lb)+"\trb:" + Arrays.toString(rb) + "\tt:" + t);
        return (lb[1]*(rb[0]-t) + rb[1]*(t-lb[0])) / (rb[0] - lb[0]);
    }



}
