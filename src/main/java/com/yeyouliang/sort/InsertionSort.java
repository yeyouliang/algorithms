package com.yeyouliang.sort;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/22 : 11:18.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[][] ints = {
                {8, 9, 1, 7, 2, 3, 5, 4, 6, 0},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(insertionSort(anInt)));
        }
    }

    /**
     * 插入排序
     */
    private static int[] insertionSort(int[] ints) {
        if (ints != null && ints.length > 1) {
            for (int i = 1; i < ints.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (ints[j - 1] > ints[j]) {
                        int temp = ints[j - 1];
                        ints[j - 1] = ints[j];
                        ints[j] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
        return ints;
    }
}
