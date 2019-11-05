package com.man1s.algorithm.algorithm.thread;

import org.apache.rocketmq.common.ThreadFactoryImpl;

import java.util.concurrent.*;

public class TestComplateService {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(3);
        CompletionService service = new ExecutorCompletionService(executor);

    }
}
