package com.yeyouliang.sort;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/22 : 11:21.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[][] ints = {
                {8, 9, 1, 7, 2, 3, 5, 4, 6, 0},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(quickSort(anInt)));
        }
    }

    /**
     * 快速排序
     */
    private static int[] quickSort(int[] ints) {
        if (ints != null && ints.length > 1) {
            int[] a = new int[ints.length];
            int[] b = new int[ints.length];
            int c = 0;
            int d = 0;
            for (int i = 1; i < ints.length; i++) {
                if (ints[i] >= ints[0]) {
                    b[d++] = ints[i];
                } else {
                    a[c++] = ints[i];
                }
            }
            ints[c] = ints[0];
            int[] e = new int[c];
            System.arraycopy(a, 0, e, 0, c);
            int[] f = new int[d];
            System.arraycopy(b, 0, f, 0, d);
            int[] g = quickSort(e);
            int[] h = quickSort(f);
            System.arraycopy(g, 0, ints, 0, c);
            System.arraycopy(h, 0, ints, c + 1, d);
        }
        return ints;
    }
}
