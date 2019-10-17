package com.quaint.studyproject.test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.function.Consumer;

/**
 * @Description: 成功，失败，回调函数测试
 * @author: qi cong
 * @Date: Created in 2019/10/12 15:39
 */
public class QuaintTestFunctionRecord {


    // --quaint1017 【测试反射的部分内容】 (Be used for [ctrl+h])

    private static Class<?> JAVASSIST_PROXY_FACTORY_CLASS;
    private static Method JAVASSIST_IS_PROXY_CLASS_METHOD;


    public static void main(String[] args) {

    }



    public static <T> Class<T> deProxy(Class<?> type) {
        // Ignore JDK proxies
        if (type.isInterface())
            return (Class<T>) type;

        if (isProxied(type)) {
            final Class<?> superclass = type.getSuperclass();
            if (!superclass.equals(Object.class) && !superclass.equals(Proxy.class))
                return (Class<T>) superclass;
            else {
                Class<?>[] interfaces = type.getInterfaces();
                if (interfaces.length > 0)
                    return (Class<T>) interfaces[0];
            }
        }

        return (Class<T>) type;
    }

    public static boolean isProxied(Class<?> type) {
        if (type.getName().contains("$ByteBuddy$"))
            return true;
        if (type.getName().contains("$$EnhancerBy"))
            return true;
        if (Proxy.isProxyClass(type))
            return true;
        return isProxiedByJavassist(type);
    }

    private static boolean isProxiedByJavassist(Class<?> type) {
        try {
            return JAVASSIST_IS_PROXY_CLASS_METHOD != null
                    && (Boolean) JAVASSIST_IS_PROXY_CLASS_METHOD.invoke(null, type);
        } catch (Exception ignore) {
        }
        return false;
    }






    // --quaint1017 【测试 回调函数】 (Be used for [ctrl+h])
//    public static void main(String[] args) {
//
//        testFun(true,
//                System.out::println,
//                ()-> System.out.println("fail"));
//
//    }
//
//    private static void testFun(boolean type, Consumer<Integer> successCall, Runnable failureCall){
//
//        if (type)
//            successCall.accept(1);
//        else
//            failureCall.run();
//        successCall.andThen(successCall);
//
//    }

}
