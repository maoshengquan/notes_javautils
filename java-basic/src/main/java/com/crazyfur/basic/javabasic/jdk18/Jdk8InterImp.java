package com.crazyfur.basic.javabasic.jdk18;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/7/4 0004
 * //TODO
 */
public class Jdk8InterImp implements Jdk8Inter{
    @Override
    public void test0() {
        System.out.println("test0() ");
    }

    public static void main(String[] args) {
        Jdk8Inter jdk8Inter = new Jdk8InterImp();
        jdk8Inter.test0();
        jdk8Inter.test1();
        Jdk8Inter.test2();
    }
}
