package com.crazyfur.basic.javabasic.mutilthread;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/5 0005
 * //TODO
 */
public class Test4 {

    public static void main(String[] args) {
        Thread son = new Thread(() -> {
            while (true) {
                //
                try {
                    System.out.println("son");
                    Thread.sleep(50);
                } catch (Exception e) {

                }
            }
        });

        son.setDaemon(true);
        son.start();

        System.out.println("main");

    }

}
