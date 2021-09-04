package com.crazyfur.basic.javabasic.mutilthread.mycallable;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/5 0005
 * //TODO
 */
public class MyFurterTask<V> implements Runnable{

    private final MyCallable<V> myCallable;
    private final Object lock = new Object();

    public MyFurterTask( MyCallable<V>  myCallable){
        this.myCallable = myCallable;
    }

    private Integer result;

    @Override
    public void run() {
        result = (Integer) myCallable.call();
        synchronized (lock){
            lock.notify();
        }
    }

    public Integer get(){
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
