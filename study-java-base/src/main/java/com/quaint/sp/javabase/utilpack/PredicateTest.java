package com.quaint.sp.javabase.utilpack;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/10/30 10:00
 */
@Data
public class PredicateTest {

    private String test;
    private Object objNull;

    public PredicateTest(String test, Object obj_null) {
        this.test = test;
        this.objNull = obj_null;
    }

    public static void main(String[] args) {

        List<String> lists = new ArrayList<>();
        lists.add("abc");
        lists.add("acb");
        lists.add("bac");
        lists.add("bca");
        lists.add("cab");
        lists.add("cba");
        Predicate<String> p1 = "abc"::equals;
        Predicate<String> p2 = i->"acb".equals(i);
        Predicate<String> p3 = i->i.equals("bac");
        Predicate<String> p4 = i->true;
        List<String> abc = lists.stream().filter(p1.or(p2).or(p3).and(p4)).collect(Collectors.toList());
//        List<String> abc = lists.stream().filter(i -> i.equals("abc")).collect(Collectors.toList());
        // 过滤成新的 list
        System.out.println(abc.size());
        abc.forEach(System.out::println);

        System.out.println("--------------------------------------");

        List<PredicateTest> testList = new ArrayList<>();
        testList.add(new PredicateTest("test1",null));
        testList.add(new PredicateTest("test2","null"));
        testList.add(new PredicateTest("test3","obj"));

        Map<String, Object> objectMap = testList.stream()
                .filter(p -> p.getObjNull() != null)
                .collect(Collectors.toMap(PredicateTest::getTest, PredicateTest::getObjNull));

        objectMap.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });

    }

}
