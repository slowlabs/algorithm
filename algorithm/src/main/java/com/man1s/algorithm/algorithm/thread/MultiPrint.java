package com.man1s.algorithm.algorithm.thread;

import io.netty.util.internal.ConcurrentSet;
import lombok.Data;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MultiPrint {

    public static void main(String[] args) {

        LockData data = new LockData(1);
         new Thread(new Print(data)).start();
         new Thread(new Print(data)).start();
         new Thread(new Print(data)).start();
         new Thread(new Print(data)).start();
         new Thread(new Print(data)).start();
    }


}
class Print implements Runnable{

    LockData data;

    public Print(LockData data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true){
            int lock = data.getLock();
            if (lock==0){
                data.setLock(lock+1);
                int num = data.getNum();
                System.out.println(Thread.currentThread().getName()+ "/name."+ num++);
                data.setNum(num);
                Map<Integer, Integer> set = data.getSet();
                if(set.containsKey(num)){
                    System.out.println("error,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,..................");
                }
                set.put(num,0);
                data.setLock(lock);
            }
        }
    }
}

@Data
class LockData{
    private volatile int num;
    private Map<Integer,Integer> set = new ConcurrentHashMap<>();
    private volatile int lock = 0;

    public LockData(int num) {
        this.num = num;
    }
}
