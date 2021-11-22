package com.yeyouliang.sort;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/22 : 11:19.
 */
public class ShellSort {
    public static void main(String[] args) {
        int[][] ints = {
                {8, 9, 1, 7, 2, 3, 5, 4, 6, 0},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(shellSort(anInt)));
        }
    }

    /**
     * 希尔排序
     */
    private static int[] shellSort(int[] ints) {
        if (ints != null && ints.length > 1) {
            int a = ints.length / 2;
            while (a > 0) {
                for (int i = ints.length - 1; i > 0; i--) {
                    int b = i;
                    int c = i - a;
                    boolean d = true;
                    while (c >= 0) {
                        if (ints[c] > ints[b]) {
                            int temp = ints[c];
                            ints[c] = ints[b];
                            ints[b] = temp;
                        }
                        b = c;
                        c -= a;
                        d = false;
                    }
                    if (d) {
                        break;
                    }
                }
                a /= 2;
            }
        }
        return ints;
    }
}
