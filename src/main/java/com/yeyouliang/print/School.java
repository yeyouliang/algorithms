package com.yeyouliang.print;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/11/28 : 10:46.
 */
public class School {

    private static Lock lock = new ReentrantLock();
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        List<String> names = Stream.of("小张", "小李", "小王", "小赵", "小周", "小吴", "小郑").collect(Collectors.toList());
        for (String name : names) {
            new Student(name).start();
        }
        Thread.sleep(3000);
        Teacher teacher = new Teacher("五柳先生");
        teacher.start();
    }

    private static class Teacher extends Thread {

        Teacher(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "：开始布置暑假作业");
            while (true) {
                if (students.isEmpty()) {
                    break;
                } else {
                    try {
                        lock.lock();
                        Student student = students.get(0);
                        students = new ArrayList<>(students.subList(1, students.size()));
                        String task = "写" + (students.size() + 1) + "篇作文";
                        System.out.println(Thread.currentThread().getName() + "：" + student.getName() + "同学要" + task);
                        student.setTask(task);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class Student extends Thread {

        Condition condition;
        String task;

        Student(String name) {
            super(name);
            condition = lock.newCondition();
            report();
        }

        void report() {
            students.add(this);
        }

        void setTask(String task) {
            this.task = task;
            condition.signal();
        }

        @Override
        public void run() {
            try {
                lock.lock();
                condition.await();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "：作业（" + task + "）已完成");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
