package com.example.myalgorithm;

import android.util.Log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * BlockingQueue方式是最优实现方式，使用ArrayBlockingQueue或LinkedBlockingQueue都可以实现，内部是通过ReentrantLock+ 两个Condition实现的生产者线程之间的同步(进队)、消费者线程之间的同步(出队)；
 *
 * 方式二的实现方式与方式一基本一致，区别在于通过reentrantLock.newCondition()只初始化了一个Condition Queue，相当于生产者、消费者线程都在一个队列里维护了，那么就不能精确唤醒对应线程了。
 *
 * 方式三效率相对于方式一来说，效率会差一些，因为当唤醒线程的时候是随机的，并不能精确唤醒对应类型(生产者 or 消费者)的线程。
 */
public class ProduceComsumeUtil {

    private static final String THREAD_PRODUCE = "生产者";
    private static final String THREAD_CONSUME = "消费者";
    private ArrayBlockingQueue<Integer> blockingDeque = new ArrayBlockingQueue<Integer>(5);

    private PublicResource publicResource = new PublicResource();
    private TaskResource taskResource = new TaskResource();

    public void blockingQueueMethod() {
        new Thread(new Task(THREAD_PRODUCE)).start();
        new Thread(new Task(THREAD_CONSUME)).start();
    }

    public void testIntegerInt() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        Log.e("jinguangyue", "" + (c == d)); // true
        Log.e("jinguangyue", "" + (e == f)); // false
        Log.e("jinguangyue", "" + (c == (a + b))); // true
        Log.e("jinguangyue", "" + (c.equals(a+b))); // true
        Log.e("jinguangyue", "" + (g == (a+b))); // true
        Log.e("jinguangyue", "" + (g.equals(a+b))); // false


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
                    Thread.sleep(500);

                    if (THREAD_PRODUCE.equals(name)) {
//                        int produceRandom = new Random().nextInt(1000);
//                        blockingDeque.add(produceRandom);

                        taskResource.increase();
//                        publicResource.increase();
//                        Log.e("jinguangyue", "ThreadName===" + Thread.currentThread().getName() + "生产元素:" + produceRandom);
                    } else if (THREAD_CONSUME.equals(name)) {
//                        int consume = blockingDeque.take();
//                        publicResource.deCrease();
                        taskResource.decrease();
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


    public class TaskResource {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        private final int maxSize = 10;
        AtomicInteger resourceNum = new AtomicInteger(0);

        public void increase() throws InterruptedException {
            reentrantLock.lock();
            while (resourceNum.get() == maxSize) {
                condition.await();
            }

            resourceNum.getAndIncrement();
            Log.e("jinguangyue", "ThreadName===" + Thread.currentThread().getName() + "生产元素:" + resourceNum.get());
            condition.signalAll();

            reentrantLock.unlock();
        }

        public void decrease() throws InterruptedException {
            reentrantLock.lock();
            while (resourceNum.get() <= 0) {
                condition.await();
            }

            resourceNum.getAndDecrement();
            Log.e("jinguangyue", "ThreadName===" + Thread.currentThread().getName() + "消费元素:" + resourceNum.get());
            condition.signalAll();

            reentrantLock.unlock();
        }
    }
}









