package com.yeyouliang.ti;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by YYL on 2021/11/18 : 14:24.
 */
public class T2 {
    /**
     * 计算1至100的正整数之和。
     * */
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int count = forkJoinPool.invoke(new MyRecursiveTask(1, 100));
        System.out.println(count);
        forkJoinPool.shutdown();
    }

    private static class MyRecursiveTask extends RecursiveTask<Integer> {

        int start;
        int end;

        MyRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (start > end) {
                return 0;
            } else if (start == end) {
                return start;
            } else {
                int middle = (end - start) / 2;
                return new MyRecursiveTask(start, start + middle).compute() + new MyRecursiveTask(start + middle + 1, end).compute();
            }
        }
    }
}
