package com.yeyouliang.print;

import java.util.*;

/**
 * Created by YYL on 2021/11/24 : 21:58.
 */
public class P_C {

    private final static Object object = new Object();
    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer("生产者");
        Consumer consumer = new Consumer("消费者");
        producer.start();
        Thread.sleep(500);
        consumer.start();
    }

    private static int getN() {
        return num;
    }

    private static void setN(int n) {
        num = n;
    }

    /**
     * 生产者
     * */
    private static class Producer extends Thread {

        public Producer(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    int n = new Random().nextInt(20);
                    setN(n);
                    System.out.println(Thread.currentThread().getName() + " 生产： " + n);
                    object.notify();
                    try {
                        Thread.sleep(1000);
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 消费者
     * */
    private static class Consumer extends Thread {

        public Consumer(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    int n = getN();
                    System.out.println(Thread.currentThread().getName() + " 消费： " + n);
                    object.notify();
                    try {
                        Thread.sleep(1000);
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
