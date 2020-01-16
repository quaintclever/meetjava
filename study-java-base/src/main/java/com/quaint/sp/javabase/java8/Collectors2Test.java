package com.quaint.sp.javabase.java8;

import com.quaint.sp.javabase.java8.function.Collectors2FunctionTest;

import static com.quaint.sp.javabase.java8.helper.HelperSupplier.bookList;
import static com.quaint.sp.javabase.java8.helper.HelperSupplier.boxList;

/**
 * @author quaint
 * @date 2020-01-16 15:33
 */
public class Collectors2Test extends Collectors2FunctionTest {

    public static void main(String[] args) {

        testGroupingByFunction(bookList);
        testGroupingByAveragingInt(bookList);
        testCollectingAndThen(boxList);
        testCounting(bookList);

    }



}
