package com.quaint.studyproject.test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 反射学习
 * @author: qi cong
 * @Date: Created in 2019/10/17 14:09
 */
public class TempTest {

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

}
