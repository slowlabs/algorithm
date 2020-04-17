package com.man1s.algorithm.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgorithmApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlgorithmApplication.class, args);
    }

}






class Test implements Runnable {
    private static int max = 100;

    private static int i = 0;

    private static volatile boolean flag = true;



    @Override
    public void run() {
        while (i<=max) {
            if(flag){
                flag = false;
                System.out.println(i);
                i++;
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        int i = 0;
        while (i<max){
            Thread t1 = new Thread(new Test());
            t1.start();
        }


    }
}