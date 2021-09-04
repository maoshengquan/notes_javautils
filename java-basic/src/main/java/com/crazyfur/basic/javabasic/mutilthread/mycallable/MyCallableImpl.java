package com.crazyfur.basic.javabasic.mutilthread.mycallable;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/5 0005
 * //TODO
 */
public class MyCallableImpl implements MyCallable<Integer> {

    @Override
    public Integer call() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 100;
    }
}
