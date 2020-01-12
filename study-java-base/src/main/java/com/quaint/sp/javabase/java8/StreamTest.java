package com.quaint.sp.javabase.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author quaint
 * @date 2020-01-12 13:44
 */
public class StreamTest {

    @Data
    @AllArgsConstructor
    public static class StreamTestUser{

        private String name;
        private String local;
        private Integer age;

    }

    public static void main(String[] args) {

        List<StreamTestUser> list = Arrays.asList(
            new StreamTestUser("quaint","Shanghai",20),
            new StreamTestUser("you","Beijing",21),
            new StreamTestUser("she","Shanghai",22),
            new StreamTestUser("cat","Tokyo",23)
        );

        System.out.println("= = = = = = = = = = = = = = = = =");
        // age 求和
        Integer sumAge = list.stream().map(StreamTestUser::getAge).reduce(0, Integer::sum);
        System.out.println(sumAge);

        System.out.println("= = = = = = = = = = = = = = = = =");
        // 找出所有上海的 根据 名字排序
        List<StreamTestUser> shanghaiName = list.stream()
                .filter(u -> "Shanghai".equals(u.getLocal()))
                .sorted(Comparator.comparing(StreamTestUser::getName))
                .collect(Collectors.toList());
        System.out.println(shanghaiName);

        System.out.println("= = = = = = = = = = = = = = = = =");
        // 找出年龄最大的 user
        Optional<StreamTestUser> first = list.stream()
                .sorted((u1,u2) -> u2.getAge().compareTo(u1.getAge())).findFirst();
        System.out.println(first.orElseGet(() ->new StreamTestUser("no","no",1)));

        Optional<StreamTestUser> maxAge = list.stream().reduce((a, b) -> a.getAge() > b.getAge() ? a : b);
        // 直接使用get 可能会存在空指针异常
        System.out.println(maxAge.get());

        System.out.println("= = = = = = = = = = = = = = = = =");


    }

}
