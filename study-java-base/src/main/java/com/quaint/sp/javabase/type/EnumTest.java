package com.quaint.sp.javabase.type;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/19 14:13
 */
public enum  EnumTest {

    /**
     * test1
     */
    NAME_1(1,"code1","名字1"),
    /**
     * test2
     */
    NAME_2(2,"code2","名字2"),

    ;


    private int val;
    private String code;
    private String name;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    EnumTest(int val, String code, String name) {
        this.val = val;
        this.code = code;
        this.name = name;
    }

}
