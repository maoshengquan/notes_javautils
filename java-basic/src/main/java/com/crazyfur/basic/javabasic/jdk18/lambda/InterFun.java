package com.crazyfur.basic.javabasic.jdk18.lambda;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.crazyfur.basic.javabasic.jdk18.lambda.InterFun
 * @description 函数式接口
 * @date 2021/7/4 0004
 * //TODO
 */
@FunctionalInterface
public interface InterFun {
    int sayHello(int a,int b);
    default void test(){
        System.out.println("test()...");
    }
    String toString();
}
