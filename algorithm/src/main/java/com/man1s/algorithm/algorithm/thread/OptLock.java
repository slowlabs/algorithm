package com.man1s.algorithm.algorithm.thread;

import java.util.concurrent.locks.StampedLock;

public class OptLock {

    public static void main(String[] args) {
        OptLock optLock = new OptLock();
        new Thread(()->optLock.moveIfAtOrigin(0.1,0.1)).start();
        new Thread(()->optLock.moveIfAtOrigin(0.1,0.1)).start();


    }


    private double x, y;
    final StampedLock sl = new StampedLock();

    // 存在问题的方法
    void moveIfAtOrigin(double newX, double newY) {
        long stamp = sl.readLock();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            while (x == 0.0 && y == 0.0) {
                stamp  = sl.tryConvertToWriteLock(stamp);
                if (stamp != 0L) {
                    x = newX;
                    y = newY;
                    break;
                } else {
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }
    }
}
