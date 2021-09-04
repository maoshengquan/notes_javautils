package com.crazyfur.basic.javabasic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/7/3 0003
 * //TODO
 */
public class Main {

    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<UserEntity> userEntityClass = UserEntity.class;
        UserEntity userEntity = userEntityClass.newInstance();
        Constructor<UserEntity> declaredConstructor = userEntityClass.getDeclaredConstructor(String.class,Integer.class);
        UserEntity crazyfur = declaredConstructor.newInstance("crazyfur", 18);
    }

}
