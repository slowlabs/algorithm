package com.man1s.algorithm.algorithm.thread;

import java.util.concurrent.CompletableFuture;

public class Completable {
    public static void main(String[] args) {

        CompletableFuture<Void> f1 =
                CompletableFuture.runAsync(()->{
                    try {
                        System.out.println("T1:洗水壶...");
                        Thread.sleep(1);
                        System.out.println("T1:烧开水...");
                        Thread.sleep(15);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                });
        //任务2：洗茶壶->洗茶杯->拿茶叶
        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(()->{
                    try {
                        System.out.println("T2:洗茶壶...");
                        Thread.sleep(1);

                        System.out.println("T2:洗茶杯...");
                        Thread.sleep(2);

                        System.out.println("T2:拿茶叶...");
                        Thread.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return "龙井";
                });


        //任务3：任务1和任务2完成后执行：泡茶
        CompletableFuture<String> f3 =
                f1.thenCombine(f2, (__, tf)->{
                    System.out.println("T1:拿到茶叶:" + tf);
                    System.out.println("T1:泡茶...");
                    return "上茶:" + tf;
                });
        //等待任务3执行结果
        System.out.println(f3.join());

    }


}
