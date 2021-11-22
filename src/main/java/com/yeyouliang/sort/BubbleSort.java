package com.yeyouliang.sort;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/22 : 11:14.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[][] ints = {
                {8, 9, 1, 7, 2, 3, 5, 4, 6, 0},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(bubbleSort(anInt)));
        }
    }

    /**
     * 冒泡排序
     */
    private static int[] bubbleSort(int[] ints) {
        if (ints != null && ints.length > 1) {
            for (int i = ints.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (ints[j] > ints[j + 1]) {
                        int temp = ints[j];
                        ints[j] = ints[j + 1];
                        ints[j + 1] = temp;
                    }
                }
            }
        }
        return ints;
    }
}
