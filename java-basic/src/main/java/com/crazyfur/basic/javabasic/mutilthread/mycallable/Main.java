package com.crazyfur.basic.javabasic.mutilthread.mycallable;

import java.util.concurrent.FutureTask;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/5 0005
 * //TODO
 */
public class Main {

    public static void main(String[] args) {
        MyCallable<Integer> myCallable = new MyCallableImpl();
        MyFurterTask myFurterTask = new MyFurterTask(myCallable);
        new Thread(myFurterTask).start();
        Integer integer = myFurterTask.get();
        System.out.println(integer);
    }

}
