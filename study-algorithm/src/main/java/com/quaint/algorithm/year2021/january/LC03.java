package com.quaint.algorithm.year2021.january;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 18 January 2021
 */
public class LC03 {

    public static void main(String[] args) {
        //设置基本信息
        List<String> list = new ArrayList<>();
        list.add("Fern");
        list.add("Fern5@m.co");
        list.add("Fern1@m.co");
        list.add("Fern0@m.co");
        list.sort(String::compareTo);
        list.forEach(System.out::println);
    }

}
