package com.example.myalgorithm.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {
    private static final Lock fairLock = new ReentrantLock(true); // 创建一个公平锁

    public static void main(String[] args) {
        Runnable fairLockTask = () -> {
            while (true) {
                try {
                    fairLock.lock();
                    System.out.println(Thread.currentThread().getName() + " acquired the lock");
                    Thread.sleep(1000); // 模拟临界区内的操作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " releasing the lock");
                    fairLock.unlock();
                }
            }
        };

        // 创建多个线程并启动
        Thread thread1 = new Thread(fairLockTask, "Thread-1");
        Thread thread2 = new Thread(fairLockTask, "Thread-2");
        Thread thread3 = new Thread(fairLockTask, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
