package com.quaint.javabase.java8;

import com.quaint.javabase.java8.function.Collectors2FunctionTest;

/**
 * @author quaint
 * @date 2020-01-16 15:33
 */
public class Collectors2Test extends Collectors2FunctionTest {

    public static void main(String[] args) {

        testGroupingByFunction();
        testGroupingByAveragingInt();
        testCollectingAndThen();
        testCounting();
        testGroupingByFunctionAndAveragingInt();
        testGroupingByFunctionAndMap();
        testGroupingByConcurrent();
        testGroupingByConcurrentWithCollectors();
        testGroupingByConcurrentWithCollectorsWithSkipTable();
        testJoining();
        testJoiningWithDelimiter();
        testJoiningWithDelimiterAndPrefixAndSuffix();
        testMapping();
        testMaxBy();
        testMinBy();
        testPartitioningBy();
        testPartitioningByCollectors();
        testReducingBinaryOperator();
        testReducingBinaryOperatorWithIdentity();
        testReducingBinaryOperatorWithIdentityAndFunction();
        testSummarizingInt();
        testSummarizingLong();
        testSummarizingDouble();
        testSummingInt();
        testSummingLong();
        testSummingDouble();

    }



}
