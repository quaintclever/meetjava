package com.quaint.javabase.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 08 May 2020
 */
public class ReflectTest {

    public static void main(String[] args) {

        SecureRandom numberGenerator = new SecureRandom();
        byte[] randomBytes = new byte[16];
        numberGenerator.nextBytes(randomBytes);
        randomBytes[6]  &= 0x0f;  /* clear version        */
        randomBytes[6]  |= 0x40;  /* set to version 4     */
        randomBytes[8]  &= 0x3f;  /* clear variant        */
        randomBytes[8]  |= 0x80;  /* set to IETF variant  */


        Class<UUID> uuidClass = UUID.class;
        try {
            Constructor<UUID> declaredConstructor = uuidClass.getDeclaredConstructor(byte[].class);
            declaredConstructor.setAccessible(true);
            UUID uuid = declaredConstructor.newInstance(randomBytes);
            System.out.println(uuid);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }

}
