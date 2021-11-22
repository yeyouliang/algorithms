package com.yeyouliang.sort;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/22 : 11:16.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[][] ints = {
                {8, 9, 1, 7, 2, 3, 5, 4, 6, 0},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(selectionSort(anInt)));
        }
    }

    /**
     * 选择排序
     */
    private static int[] selectionSort(int[] ints) {
        if (ints != null && ints.length > 1) {
            for (int i = 0; i < ints.length - 1; i++) {
                int a = i;
                int b = ints[i];
                for (int j = i + 1; j < ints.length; j++) {
                    if (ints[j] < b) {
                        a = j;
                        b = ints[j];
                    }
                }
                if (a != i) {
                    int temp = ints[i];
                    ints[i] = ints[a];
                    ints[a] = temp;
                }
            }
        }
        return ints;
    }
}
