package com.crazyfur.basic.javabasic.mutilthread;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/6 0006
 * //TODO
 */
public class Test6 {

    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                System.out.println("123");
            }
        },"test-cpu-1").start();
    }

}
