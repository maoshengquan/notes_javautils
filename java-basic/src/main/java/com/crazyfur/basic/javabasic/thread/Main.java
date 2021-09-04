package com.crazyfur.basic.javabasic.thread;

import java.util.concurrent.*;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/7/4 0004
 * //TODO
 */
public class Main {

    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("voidCompletableFuture");
        }, executorService);

        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {

            return 1;
        }, executorService).whenComplete((res,e) -> {
            System.out.println("res:"+res);
        }).exceptionally((Throwable) -> {
            return 10;
        });

        CompletableFuture.supplyAsync(() -> {
            return 100;
        },executorService).handle((res,throwable)->{
            if (throwable != null){
                return 200;
            }
            return res;
        });

        System.out.println("main");
        executorService.shutdown();
    }

}
