package com.quaint.javabase.base;

import sun.misc.Unsafe;

/**
 * -Xbootclasspath/a: path
 * 意思是 追加 bootclass 类加载器扫秒的路径
 */
public class BaseClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(BaseClassLoaderTest.class.getClassLoader());
        Inner in = new Inner();
        in.hello();
        System.out.println(String.class.getClassLoader());
        System.out.println(Unsafe.class.getClassLoader());
    }

    public static class Inner {

        public void hello() {
            // has error.
//            try {
//                System.setSecurityManager(new SecurityManager());
//                Class callerClass = Reflection.getCallerClass();
//                Method method = callerClass.getMethod("hello");
//                Object o = new Object();
//                method.invoke(o);
//            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(Reflection.getCallerClass());
        }
    }

}
