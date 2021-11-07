package com.yeyouliang.sort;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/7 : 14:11.
 */
public class NewSort {

    public static void main(String[] args) {
        int[][] ints = {
                {5, 1, 3, 9, 8, 2, 6, 4, 7},
                {2},
                {2, 1},
                {2, 2},
                {2, 5},
                {2, 5, 3, 1, 4},
                {1, 2, 3, 3},
                {2, 1, 2, 5, 3, 2},
                {5, 1, 5, 2, 5, 3, 5, 4},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(kuaipai(anInt)));
        }
    }

    private static int[] maopao(int[] ints) {
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

    private static int[] kuaipai(int[] ints) {
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
            int []e=new int[a.length];
            System.arraycopy(a,0,e,0,a.length);
            int []f=new int[b.length];
            System.arraycopy(b,0,f,0,b.length);
            System.arraycopy(e, 0, ints, 0, c);
            System.arraycopy(f, 0, ints, c+1, d);
        }
        return ints;
    }
}
