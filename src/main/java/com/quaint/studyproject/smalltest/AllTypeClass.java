package com.quaint.studyproject.smalltest;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/1 15:53
 */
@Data
public class AllTypeClass {

    /**
     * ------- 引用数据类型 -------
     */
    private String stringVal;

    private MemberInfo memberInfo;

    private List<Object> objectList;

    private Set<Object> objectSet;

    private Map<Object,Object> objectObjectMap;

    /**
     * ------- 包装类 -------
     */
    private Byte byteVal;

    private Short shortVal;

    private Integer integerVal;

    private Long longVal;

    private Float floatVal;

    private Double doubleVal;

    private Boolean booleanVal;

    private Character characterVal;

    /**
     * ------- 基本数据类型 -------
     */
    private byte aByte;

    private short aShort;

    private int anInt;

    private long aLong;

    private float aFloat;

    private double aDouble;

    private boolean aBoolean;

    private char aChar;

    @Data
    public class MemberInfo{

        private String name;

        private Integer age;
    }

}
