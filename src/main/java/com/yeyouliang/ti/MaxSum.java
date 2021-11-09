package com.yeyouliang.ti;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/9 : 22:17.
 */
public class MaxSum {
    /**
     * 子数组之和的最大值
     * 对于一个有N个整数元素的一维数组，找出它的子数组（数组中下标连续的元素组成的数组）之和的最大值。
     * */
    public static void main(String[] args) {
        int[][] ints = {
                {1, -2, 3, 5, -3, 2},
                {0, -2, 3, 5, -1, 2},
                {-9, -2, -3, -5, -3},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + ms(anInt));
        }
    }

    private static int ms(int[] ints) {
        int[] a = new int[ints.length];
        int m = ints[0];
        a[0] = ints[0];
        for (int i = 1; i < ints.length; i++) {
            int b = ints[i];
            int c = a[i - 1];
            if (c < 0) {
                m = Math.max(b, m);
                a[i] = b;
            } else {
                if (b >= 0) {
                    m = Math.max(b + c, m);
                }
                a[i] = b + c;
            }
        }
        return m;
    }
}
