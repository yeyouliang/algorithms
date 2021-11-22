package com.yeyouliang.sort;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/22 : 11:20.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[][] ints = {
                {8, 9, 1, 7, 2, 3, 5, 4, 6, 0},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(mergeSort(anInt)));
        }
    }

    /**
     * 归并排序
     */
    private static int[] mergeSort(int[] ints) {
        if (ints != null && ints.length > 1) {
            if (ints.length == 2) {
                if (ints[0] > ints[1]) {
                    int temp = ints[0];
                    ints[0] = ints[1];
                    ints[1] = temp;
                }
            } else {
                int a = ints.length / 2;
                int[] b = new int[a];
                int[] c = new int[ints.length - a];
                System.arraycopy(ints, 0, b, 0, b.length);
                System.arraycopy(ints, a, c, 0, c.length);
                int[] d = mergeSort(b);
                int[] e = mergeSort(c);
                int f = 0;
                int g = 0;
                int h = 0;
                while (true) {
                    if (g == d.length) {
                        for (int i = h; i < e.length; i++) {
                            ints[f++] = e[i];
                        }
                        break;
                    }
                    if (h == e.length) {
                        for (int i = g; i < d.length; i++) {
                            ints[f++] = d[i];
                        }
                        break;
                    }
                    if (d[g] < e[h]) {
                        ints[f++] = d[g++];
                    } else {
                        ints[f++] = e[h++];
                    }
                }
            }
        }
        return ints;
    }
}
