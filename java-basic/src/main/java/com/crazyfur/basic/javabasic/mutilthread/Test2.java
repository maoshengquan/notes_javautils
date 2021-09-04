package com.crazyfur.basic.javabasic.mutilthread;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/5 0005
 * //TODO
 */
public class Test2 {
    private static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Test2 test2 = new Test2();
        test2.print();
        Thread.sleep(1000);
        synchronized (lock){
            try {
                Thread.sleep(3000);
                lock.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  void print(){
        new Thread(()->{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+"(1)");
                try {
                    lock.wait();
                    System.out.println(Thread.currentThread().getName()+"(2)");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
