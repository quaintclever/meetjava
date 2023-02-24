package com.quaint.javabase.jdkutil;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class JdkClassUtil {

    public static Unsafe getUnsafe() {
        Class<Unsafe> unsafeClass = Unsafe.class;
        try {
            Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
