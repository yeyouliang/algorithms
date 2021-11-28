package com.yeyouliang.print;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YYL on 2021/11/28 : 9:19.
 */
public class P_C_1 {

    private final static Lock lock = new ReentrantLock();
    private final static Condition condition = lock.newCondition();
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
     */
    private static class Producer extends Thread {

        Producer(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    int n = new Random().nextInt(20);
                    setN(n);
                    System.out.println(Thread.currentThread().getName() + " 生产： " + n);
                    condition.signal();
                    try {
                        Thread.sleep(1000);
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    /**
     * 消费者
     */
    private static class Consumer extends Thread {

        Consumer(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    int n = getN();
                    System.out.println(Thread.currentThread().getName() + " 消费： " + n);
                    condition.signal();
                    try {
                        Thread.sleep(1000);
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
