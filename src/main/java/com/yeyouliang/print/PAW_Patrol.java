package com.yeyouliang.print;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/11/27 : 10:35.
 */
public class PAW_Patrol {

    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static List<String> tasks = Stream.of("救火", "救溺", "导航", "修理", "找失", "搜救").collect(Collectors.toList());
    private static List<String> members = Stream.of("阿奇", "毛毛", "天天", "灰灰", "小砾", "路马").collect(Collectors.toList());
    private static String task = "";

    /**
     * 汪汪队立大功
     */
    public static void main(String[] args) {
        Thread ryder = new Thread(new Boy(), "莱德");
        ryder.start();
        for (String dog : members) {
            Thread d = new Thread(new Dog(), dog);
            d.start();
        }
    }

    private static class Boy implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "：汪汪队要出动喽！");
            System.out.println(Thread.currentThread().getName() + "：只要你遇到麻烦，就大声呼救！");
            while (!tasks.isEmpty()) {
                try {
                    lock.lock();
                    task = tasks.get(0);
                    System.out.println(Thread.currentThread().getName() + "：收到一个任务：" + task);
                    tasks = tasks.subList(1, tasks.size());
                    Thread.sleep(3000);
                    c1.await();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
            System.out.println(Thread.currentThread().getName() + "：没有困难的工作，只有勇敢的狗狗！");
        }
    }

    private static class Dog implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (!task.equals("")) {
                    try {
                        lock.lock();
                        if ("".equals(task)) {
                            continue;
                        }
                        System.out.println(Thread.currentThread().getName() + "：我来执行" + task + "任务");
                        System.out.println(Thread.currentThread().getName() + "：" + task + "任务执行完毕");
                        task = "";
                        c1.signal();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                    break;
                } else {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
