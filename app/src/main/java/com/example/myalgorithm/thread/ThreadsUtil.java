package com.example.myalgorithm.thread;

import android.util.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;


/**
 * CyclicBarrier和CountDownLatch的区别多线程处理
 */
public class ThreadsUtil {

    private static final int THREAD_COUNT = 3;

    public static void cyclicBarrierExample() {
        System.out.println("=== CyclicBarrier Example ===");

        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(() -> {
                Log.e("jinguangyue", Thread.currentThread().getName() + " is waiting at the barrier.");
                try {
                    cyclicBarrier.await(); // 线程在这里等待，直到所有线程都到达屏障点
                    Log.e("jinguangyue", Thread.currentThread().getName() + " has passed the barrier.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }

    public static void countDownLatchExample() {
        System.out.println("=== CountDownLatch Example ===");

        CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(() -> {
                Log.e("jinguangyue", Thread.currentThread().getName() + " has started.");
                // 模拟某个耗时操作
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.e("jinguangyue", Thread.currentThread().getName() + " has completed.");
                countDownLatch.countDown(); // 计数器减一
            });
            thread.start();
        }

        try {
            countDownLatch.await(); // 等待计数器减到零
            Log.e("jinguangyue", "All threads have completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
