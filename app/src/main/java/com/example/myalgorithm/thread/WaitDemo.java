package com.example.myalgorithm.thread;

public class WaitDemo {

    private String inputString = null;
    private final Object lock = new Object();

    private void setInputString() {
        inputString = "jinguangyue";
        synchronized (lock) {
            lock.notify();
        }
    }

    private void readString() {
        try {
            synchronized (lock) {
                lock.wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("inputString===" + inputString);
    }


    public static void main(String[] args) {

        WaitDemo demo = new WaitDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                demo.setInputString();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                demo.readString();
            }
        }).start();
    }
}
