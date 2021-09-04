package com.crazyfur.basic.javabasic.mutilthread;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/5 0005
 * //TODO
 */
public class Test3 {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println("(1)");
        });

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("(2)");
        });

        Thread t3 = new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("(3)");
        });

        // 谁调用join方法，将会进入等待状态

        t1.start();
        t2.start();
        t3.start();
    }

}
