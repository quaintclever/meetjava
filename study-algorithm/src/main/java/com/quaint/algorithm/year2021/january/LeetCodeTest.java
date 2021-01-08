package com.quaint.algorithm.year2021.january;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCodeTest {

    public static void main(String[] args) {
//        System.out.println("ans:1 =>" + findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
//        System.out.println("ans:1 =>" + findCircleNum(new int[][]{{1,1,1},{1,1,1},{1,1,1},{1,1,1}}));
//        int[][] arr = new int[][]{{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0}, {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0}, {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0}, {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0}, {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0}, {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0}, {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0}, {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0}, {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0}, {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1}, {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0}, {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0}, {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0}, {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};
//        System.out.println("ans:3 =>" + findCircleNum(arr));
//        int [][] arr2 = {{1,0,0,0,1,1,0,1,0,0,0,1,0,0,0},{0,1,0,0,1,0,1,0,0,0,0,0,0,0,0},{0,0,1,0,1,0,0,0,0,0,0,0,1,1,0},{0,0,0,1,0,0,0,0,0,0,0,1,1,1,0},{1,1,1,0,1,0,0,0,0,0,1,0,0,0,0},{1,0,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,1,0,0,0,0,1,0,1,0,0,0,0,0,0},{1,0,0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,1,0,0,0,0,0,1},{0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,0,1,0,0,1,0},{1,0,0,1,0,0,0,0,0,0,0,1,1,0,0},{0,0,1,1,0,0,0,0,0,0,0,1,1,0,0},{0,0,1,1,0,0,0,0,0,0,1,0,0,1,0},{0,0,0,0,0,0,0,0,1,0,0,0,0,0,1}};
//        System.out.println("ans:1 ==>" + findCircleNum(arr2));
//
//        int[][] arr3 = {{1,1,1,0,1,1,1,0,0,0},{1,1,0,0,0,0,0,1,0,0},{1,0,1,0,0,0,0,0,0,0},{0,0,0,1,1,0,0,0,1,0},{1,0,0,1,1,0,0,0,0,0},{1,0,0,0,0,1,0,0,0,0},{1,0,0,0,0,0,1,0,1,0},{0,1,0,0,0,0,0,1,0,1},{0,0,0,1,0,0,1,0,1,1},{0,0,0,0,0,0,0,1,1,1}};
//        System.out.println("ans:1 ==>" + findCircleNum(arr3));
        
        int[][] arr4 = {{1,1,0,0,0,0,0,1,0,1},{1,1,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,1,0,0,0,0},{0,0,1,0,0,0,1,1,0,0},{1,0,0,0,0,0,1,1,0,0},{0,0,0,0,0,0,0,0,1,1},{1,0,0,0,0,0,0,0,1,1}};
        System.out.println("ans:4 ==>" + findCircleNum(arr4));
        showList(arr4);
    }

    public static void showList(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    System.out.printf("%d--%d\t\t",i+1,j+1);
                }
            }
            System.out.println();
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        UnionFind uf = new UnionFind(size);
        for(int i = 0; i < isConnected.length; i++) {
            for(int j = i + 1; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(j,i);
                }
            }
        }

        uf.last();
        // 打印引用结果
        System.out.println(Arrays.toString(uf.parent));
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < uf.parent.length; i++) {
            set.add(uf.parent[i]);
        }
        return set.size();
    }

    private static class UnionFind {

        // 父节点idx
        public int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int idx,int parentIdx) {
            int old = parent[idx];
            parent[idx] = find(parentIdx);
            if (old != parent[idx]) {
                union(old,parent[idx]);
            }
        }

        public int find(int idx) {
            if (idx == parent[idx]) {
                return idx;
            }
            return find(parent[idx]);
        }

        public void last(){
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] != parent[parent[i]]) {
                    parent[i] = parent[parent[i]];
                }
            }
        }

    }


}