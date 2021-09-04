package com.crazyfur.basic.javabasic.annotation;

import com.crazyfur.basic.javabasic.reflect.UserEntity;

import java.lang.reflect.Method;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/7/3 0003
 * //TODO
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class<?> aClass = Class.forName("com.crazyfur.basic.javabasic.reflect.UserEntity");
        UserEntity entity =(UserEntity) aClass.newInstance();
        Method info = aClass.getDeclaredMethod("info");
        FuntionName annotation = info.getAnnotation(FuntionName.class);
        System.out.println(annotation);
    }

}
