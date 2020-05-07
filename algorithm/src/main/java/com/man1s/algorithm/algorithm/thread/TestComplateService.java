package com.man1s.algorithm.algorithm.thread;

import java.util.concurrent.CompletionService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;

public class TestComplateService {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(3);
        CompletionService service = new ExecutorCompletionService(executor);

    }
}
