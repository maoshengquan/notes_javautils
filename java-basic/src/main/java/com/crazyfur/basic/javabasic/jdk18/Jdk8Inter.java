package com.crazyfur.basic.javabasic.jdk18;

/**
 * @author xiaomao
 * @version 1.0
 * @des 接口中默认方法修饰为普通方法
 * @date 2021/7/4 0004
 * //TODO
 */
public interface Jdk8Inter {

    void test0();

    default void test1(){//通过子类的实例对象调用
        System.out.println("default void test1()");
    }

    static void test2(){//通过接口名调用：Jdk8Inter.test2()
        System.out.println("static void test2");
    }

}
