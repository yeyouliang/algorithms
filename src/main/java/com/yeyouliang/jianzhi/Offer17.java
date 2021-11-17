package com.yeyouliang.jianzhi;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/25 : 10:29.
 */
public class Offer17 {
    /**
     * 剑指 Offer 17. 打印从1到最大的n位数
     * */
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        for (int anInt : ints) {
            System.out.println(anInt + ":" + Arrays.toString(printNumbers(anInt)));
        }
    }

    private static int[] printNumbers(int n) {
        int[] ints = new int[0];
        if (n < 11) {
            int a = 1;
            int b;
            if (n == 10) {
                b = Integer.MAX_VALUE;
            } else {
                for (int i = 0; i < n; i++) {
                    a *= 10;
                }
                b = --a;
            }
            ints = new int[b];
            for (int i = 1; i <= b; i++) {
                ints[i - 1] = i;
            }
        }
        return ints;
    }
}
