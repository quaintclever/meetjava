package com.quaint.algorithm.year2021.april;

/**
 * @author quaint
 * @date 2021/4/10
 */
public class LCP01 {

    public static void main(String[] args) {
        LCP01 lcp = new LCP01();
        //                      1
        //                  1 1 1 18
        //                  2 4 4 36
        int [] bucket4 = {9,1,1,0,10}, vat4 = {0,4,8,8,1000};
        System.out.println(55 == lcp.storeWater(bucket4, vat4));

        //                  1 1 18 18
        //                  2 4 36 36
        int [] bucket5 = {9,1,1,10,10}, vat5 = {0,4,8,1000,1000};
        System.out.println(70 + "<== ans | out ==>" + lcp.storeWater(bucket5, vat5));

    }

    public int storeWater(int[] bucket, int[] vat) {

        int ans = 0;
        int[] fn = new int[bucket.length];
        int[] upCnt = new int[bucket.length];
        for (int i = 0; i < bucket.length; i++) {
            // 先把0 的桶升级
            if (bucket[i] == 0 && vat[i] != 0) {
                ans ++;
                bucket[i]++;
            }
        }

        // 贪心 寻找 每一个的极限.
        int[] fc = fullMinCnt(vat[0], bucket[0]);
        fn[0] = fc[0];
        upCnt[0] = fc[1];
        for (int i = 1; i < fn.length; i++) {
            int[] fmc = fullMinCnt(vat[i], bucket[i]);
            fn[i] = Math.max(fmc[0], fn[i-1]);
            upCnt[i] = fmc[1];
        }

        // 找到最大的极限, 其他的非极限 尽可能不升级
        for (int i = 0; i < upCnt.length; i++) {
            if(upCnt[i] > 0) {
                ans += minLevelCnt(vat[i], bucket[i], fn[fn.length - 1]);
            }
        }
        return ans + fn[fn.length - 1];
    }

    private int minLevelCnt(int vat, int bucket, int limit) {
        if (vat == 0 || bucket > vat) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int up = 0;
        while(bucket < vat) {
            int fc = fullCnt(vat, bucket);
            if(fc + up < limit) {
                break;
            }
            if (min > fc + up) {
                min = fc + up;
                up ++;
                bucket ++;
            } else {
                break;
            }
        }
        if (up > 0) {
            up --;
        }
        return up;
    }

    private int[] fullMinCnt(int vat, int bucket) {
        if (vat == 0 || bucket > vat) {
            return new int[]{0,0};
        }
        int min = Integer.MAX_VALUE;
        int up = 0;
        int finalUp = 0;
        while(bucket < vat) {
            int fc = fullCnt(vat, bucket);
            if (min > fc + up) {
                min = fc + up;
                finalUp = up;
            }
            up ++;
            bucket ++;
        }
        return new int[]{min - finalUp, finalUp};
    }

    private int fullCnt(int vat, int bucket) {
        return vat / bucket + (vat % bucket != 0 ? 1 : 0);
    }

}
