package com.example.myalgorithm;

import android.util.Log;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ProduceComsumeUtil {

    private static final String THREAD_PRODUCE = "生产者";
    private static final String THREAD_CONSUME = "消费者";
    private ArrayBlockingQueue<Integer> blockingDeque = new ArrayBlockingQueue<Integer>(5);

    private PublicResource publicResource = new PublicResource();

    public void blockingQueueMethod() {
        new Thread(new Task(THREAD_PRODUCE)).start();
        new Thread(new Task(THREAD_CONSUME)).start();
    }

    class Task implements Runnable {

        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                try {
//                    Thread.sleep(500);

                    if (THREAD_PRODUCE.equals(name)) {
//                        int produceRandom = new Random().nextInt(1000);
//                        blockingDeque.add(produceRandom);

                        publicResource.increase();
//                        Log.e("jinguangyue", "ThreadName===" + Thread.currentThread().getName() + "生产元素:" + produceRandom);
                    } else if (THREAD_CONSUME.equals(name)) {
//                        int consume = blockingDeque.take();
                        publicResource.deCrease();
//                        Log.e("jinguangyue", "ThreadName===" + Thread.currentThread().getName() + "生产元素:" + consume);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public static class PublicResource {
        private int number = 0;//当前总共生产个数
        private final int size = 5;//最大产品个数
        private final Object object = new Object();

        public void increase() throws InterruptedException {
            synchronized (object) {
                if (number >= size) {
                    object.wait();
                }

                Thread.sleep(500);
                number++;
                object.notifyAll();
                Log.e("jinguangyue", "ThreadName===" + Thread.currentThread().getName() + "生产元素:" + number);
            }
        }

        public void deCrease() throws InterruptedException {
            synchronized (object) {
                if (number <= 0) {
                    object.wait();
                }

                Thread.sleep(100);
                number--;
                object.notifyAll();
                Log.e("jinguangyue", "ThreadName===" + Thread.currentThread().getName() + "消费元素:" + number);
            }
        }
    }
}









