package com.man1s.algorithm.algorithm.thread;


import org.apache.tomcat.util.threads.TaskQueue;
import org.apache.tomcat.util.threads.TaskThreadFactory;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) {
        TaskQueue taskqueue = new TaskQueue(1);
        TaskThreadFactory tf = new TaskThreadFactory( "-exec-", true, 1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS,taskqueue, tf);
        executor.submit(new Thread(()->{}),new ArrayList<>());


        while (true){
            ((ThreadPoolExecutor) executor).submit(()->{
                System.out.println("start"+Thread.currentThread().getName());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }



    }




}
