package com.crazyfur.basic.javabasic.mutilthread;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/5 0005
 * //TODO
 */
public class Test5 {

    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Test5.count++;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Test5.count++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(Test5.count);

    }

}
