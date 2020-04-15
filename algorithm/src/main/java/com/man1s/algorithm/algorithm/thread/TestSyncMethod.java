package com.man1s.algorithm.algorithm.thread;

public class TestSyncMethod {
    public static void main(String[] args) {
        new Thread(new ThreadS1()).start();
        new Thread(new ThreadS2()).start();

    }

}

class ThreadS1 implements Runnable{
    @Override
    public void run() {
        while (true){
            TestS.add();
        }
    }
}
class ThreadS2 implements Runnable{
    @Override
    public void run() {
       while (true){
           TestS.add1();
       }
    }
}

class TestS{
    private static int  i = 0;

    public static synchronized  void add(){
        while (true){
            System.out.println(i++);
        }
    }



    public static synchronized  void add1(){
        System.out.println("test1"+i++);
    }
}

