package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/10/1 : 7:08.
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 125, 255, 256, 1024, 3306, 10000, 10010, 10086, 65536, Integer.MAX_VALUE};
        for (int anInt : ints) {
            System.out.println(anInt + ":" + isPerfectSquare(anInt));
        }
    }

    /**
     * 367. 有效的完全平方数
     * */
    private static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        } else {
            int start = 1;
            int end = num;
            while (start < end - 1) {
                int b = (end - start) / 2;
                int c = start + b;
                long d = (long) c * (long) c;
                if ((long) num == d) {
                    return true;
                } else if ((long) num < d) {
                    end = c;
                } else {
                    start = c;
                }
            }
        }
        return false;
    }
}
