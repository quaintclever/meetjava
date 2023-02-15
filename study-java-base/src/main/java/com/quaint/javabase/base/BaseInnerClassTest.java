package com.quaint.javabase.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 内部类练习
 */
public class BaseInnerClassTest {

    public static void main(String[] args) {
        // 静态方法调用非静态内部类
        BaseInnerClassTest bs = new BaseInnerClassTest();
        Inner1 inner1 = bs.new Inner1();
        inner1.show();
        // 非静态方法调用内部类
        bs.callInner1();

        // 静态方法调用静态内部类
        Inner2 i2 = new BaseInnerClassTest.Inner2();
        i2.show2();

        // 方法内部类使用
        bs.funcInnerClass();

        // 方法内部类逃脱
        Map<String, Object> m = new HashMap<>();
        String key = bs.funcInnerClass2(m);
        Object obj = m.get(key);
        Class<?> aClass = obj.getClass();
        try {
            System.out.println("className = " + aClass);
            Method showFuncInner2 = aClass.getMethod("showFuncInner2");
            // 方法内部类调用.
            showFuncInner2.invoke(obj);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    public String funcInnerClass2(Map<String, Object> m) {
        int num = 111;
        class FuncInner2 {
            public void showFuncInner2() {
                System.out.println("func inner - 2, num = " + num + "\n");
            }
        }
        FuncInner2 fi2 = new FuncInner2();
        String key = "fi2";
        m.put(key, fi2);
        return key;
    }

    public void funcInnerClass() {
        // 编译报错， 方法内部类，和变量作用域一样，先定义才能使用
//        FuncInner fi = new FuncInner();

        // 这里默认会 加 final
        int num = 30;
//        num = 31;
        class FuncInner {
            public void showFuncInner() {
                // 这里要求 num 必须是 final的。 为了保证生命周期一致。
                System.out.printf("func inner - 1, num = %d \n", num);
            }
        }
        FuncInner fi = new FuncInner();
        fi.showFuncInner();
    }

    static class Inner2 {
        public void show2() {
            System.out.println("inner - 2");
        }
    }


    public void callInner1() {
        Inner1 i1 = new Inner1();
        i1.show();
    }

    class Inner1 {
        public void show() {
            System.out.println("inner - 1");
        }
    }

}
