package com.yeyouliang.jianzhi;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/31 : 12:11.
 */
public class Offer_2_069 {
    /**
     * 剑指 Offer II 069. 山峰数组的顶部
     */
    public static void main(String[] args) {
        int[][] ints = {
                {3, 2, 1},
                {2, 3, 1},
                {1, 2, 3},
                {4, 3, 2, 1},
                {3, 4, 2, 1},
                {2, 3, 4, 1},
                {1, 2, 3, 4},
                {5, 4, 3, 2, 1},
                {4, 5, 3, 2, 1},
                {3, 4, 5, 2, 1},
                {2, 3, 4, 5, 1},
                {1, 2, 3, 4, 5},
                {6, 5, 4, 3, 2, 1},
                {5, 6, 4, 3, 2, 1},
                {4, 5, 6, 3, 2, 1},
                {3, 4, 5, 6, 2, 1},
                {2, 3, 4, 5, 6, 1},
                {1, 2, 3, 4, 5, 6},
                {0, 1, 0},
                {1, 3, 5, 4, 2},
                {0, 10, 5, 2},
                {3, 4, 5, 1},
                {24, 69, 100, 99, 79, 78, 67, 36, 26, 19},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + peakIndexInMountainArray(anInt));
        }
    }

    private static int peakIndexInMountainArray(int[] arr) {
        int a = 0;
        int b = arr.length - 1;
        while (true) {
            int c = b - a;
            if (c == 1) {
                return arr[a] > arr[b] ? a : b;
            } else {
                int d = c / 2;
                int e = a + d;
                if (arr[e] > arr[e - 1]) {
                    a = e;
                } else {
                    b = e;
                }
            }
        }
    }
}
