package com.man1s.algorithm.algorithm.thread;

public class MultiPrint {

    public static void main(String[] args) {

         Data data = new Data(1);
         new Thread(new Print(data)).start();
         new Thread(new Print(data)).start();
         new Thread(new Print(data)).start();
         new Thread(new Print(data)).start();
         new Thread(new Print(data)).start();
    }


}
class Print implements Runnable{

    Data data;

    public Print(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true){
            int lock = data.getLock();
            if (lock==0){
                data.setLock(lock+1);
                int num = data.getNum();
                System.out.println(num++);
                data.setNum(num);
                data.setLock(lock);
            }
        }
    }
}

class Data{
    private int num;

    private  int lock = 0;

    public Data(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getLock() {
        return lock;
    }

    public void setLock(int lock) {
        this.lock = lock;
    }
}
