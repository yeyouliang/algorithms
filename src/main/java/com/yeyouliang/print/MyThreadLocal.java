package com.yeyouliang.print;

/**
 * Created by YYL on 2021/12/1 : 10:02.
 */
public class MyThreadLocal {

    private static int count = 0;

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread);
        Thread b = new Thread(myThread);
        Thread c = new Thread(myThread);
        Thread d = new Thread(myThread);
        a.start();
        b.start();
        c.start();
        d.start();
    }

    private static class MyThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (count < 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    count++;
                } else {
                    break;
                }
            }
        }
    }
}
