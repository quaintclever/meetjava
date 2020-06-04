package com.quaint.javabase.utilpack;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * desc: 置顶 一个 list 中的对象
 * </p>
 *
 * @author quaint
 * @since 04 June 2020
 */
public class CollectTest {

    @Data
    @AllArgsConstructor
    private static class BodyTest {
        private String name;
        private Boolean isFirst;
    }

    public static void main(String[] args) {

        List<BodyTest> bodys = new ArrayList<>();

        bodys.add(new BodyTest("2nd", false));
        bodys.add(new BodyTest("1st", true));
        bodys.add(new BodyTest("3rd", false));

        bodys.forEach(System.out::println);

        for (int i = 1; i < bodys.size(); i++) {
            if (bodys.get(i).isFirst) {
                BodyTest temp = bodys.get(0);
                bodys.set(0,bodys.get(i));
                bodys.set(i,temp);
            }
        }

        System.out.println("=== 交换后 ===");

        bodys.forEach(System.out::println);
    }

}
