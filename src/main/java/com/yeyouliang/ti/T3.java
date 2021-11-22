package com.yeyouliang.ti;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by YYL on 2021/11/19 : 8:42.
 */
public class T3 {
    /**
     * 如何并发计算一个给定的字符在字符串中出现的次数？
     */
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int count = forkJoinPool.invoke(new IRecursiveTask("cbcd", 'c'));
        System.out.println(count);
    }

    private static class IRecursiveTask extends RecursiveTask<Integer> {

        private String a;
        private char b;

        IRecursiveTask(String a, char b) {
            this.a = a;
            this.b = b;
        }

        @Override
        protected Integer compute() {
            if (a.length() == 0) {
                return 0;
            } else if (a.length() == 1) {
                return a.charAt(0) == b ? 1 : 0;
            } else {
                int c = a.length() / 2;
                return new IRecursiveTask(a.substring(0, c), b).compute() + new IRecursiveTask(a.substring(c, a.length()), b).compute();
            }
        }
    }
}
