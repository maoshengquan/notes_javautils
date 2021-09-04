package com.crazyfur.basic.javabasic.mutilthread;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/4 0004
 * //TODO
 */
public class Test1 implements Runnable {

    private Integer count = 100;

    @Override
    public void run() {
        while (true){
            try {
                synchronized (this){
                    if (count >=1){
                        Thread.sleep(20);
                        System.out.println(Thread.currentThread().getName()+":"+this.count);
                        count--;
                    }else {
                        break;
                    }
                }
            }catch (InterruptedException e){
                e.getMessage();
            }
        }
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        new Thread(test1).start();
        new Thread(test1).start();
    }

}
