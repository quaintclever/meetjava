package com.quaint.algorithm.year2021.january;

import java.util.*;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 2021-01-06
 */
public class GetTopN
{

    public static class Node<T> {
        public T val;
        public Node<T> next;
    }

    public static void main(String[] args) {

        Node<String> node = new Node<>();
        Node<String> node2 = new Node<>();
        Node<String> node3 = new Node<>();
        Node<String> node4 = new Node<>();
        Node<String> node5 = new Node<>();
        node.val = "1";
        node2.val = "2";
        node3.val = "2";
        node4.val = null;
        node5.val = null;
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        List<String> topN = getTopN(node, -1);
        System.out.println("==== topN ====");
        topN.forEach(System.out::println);

        List<String> topN1 = getTopN(node, 1);
        System.out.println("==== topN1 ====");
        topN1.forEach(System.out::println);

        List<String> topN2 = getTopN(node, 2);
        System.out.println("==== topN2 ====");
        topN2.forEach(System.out::println);

        List<String> topN3 = getTopN(node, 3);
        System.out.println("==== topN3 ====");
        topN3.forEach(System.out::println);

        List<String> topN4 = getTopN(node, 4);
        System.out.println("==== topN4 ====");
        topN4.forEach(System.out::println);


    }

    /**
     * 返回重复次数最多的前N个data
     * <p>注意: 输入可能有异常数据,程序需要具备容错性,不能出现异常或导致系统crash的情况
     * <p>注意: 答题内容不能超过getTopN方法体
     */
    public static <T> List<T> getTopN(Node<T> header, int n) {

        Map<T,Integer> map = new HashMap<>(16);
        int nullNum = 0;
        while (header != null) {
            if (header.val == null) {
                nullNum++;
            } else {
                if (map.get(header.val) == null) {
                    map.put(header.val,1);
                } else {
                    map.put(header.val,map.get(header.val) + 1);
                }
            }
            header = header.next;
        }

        List<Map.Entry<T, Integer>> sortUsed = new ArrayList<>(map.entrySet());
        sortUsed.sort(Comparator.comparing(Map.Entry::getValue));

        List<T> ans = new ArrayList<>();
        for (int i = sortUsed.size() - 1; i >= sortUsed.size() - n && i >= 0; i--) {
            if (nullNum > sortUsed.get(i).getValue()) {
                ans.add(null);
                i++;
                n--;
                nullNum = 0;
            } else {
                ans.add(sortUsed.get(i).getKey());
            }
        }
        return ans;
    }


}
