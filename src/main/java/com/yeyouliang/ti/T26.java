package com.yeyouliang.ti;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/22 : 22:18.
 */
public class T26 {
    public static void main(String[] args) {
        int[][] ints = {
                {8, 9, 1, 7, 2, 3, 5, 4, 6, 0},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(m1(anInt)));
        }
    }

    /**
     * 输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。
     */
    private static int[] m1(int[] ints) {
        if (ints != null && ints.length > 1) {
            int a = 0;
            int b = 0;
            for (int i = 1; i < ints.length; i++) {
                if (ints[a] < ints[i]) {
                    a = i;
                }
                if (ints[i] < ints[b]) {
                    b = i;
                }
            }
            System.out.println(ints[a] + "," + ints[b]);
            if (a == ints.length - 1 && b == 0) {
                int temp = ints[a];
                ints[a] = ints[b];
                ints[b] = temp;
            } else {
                boolean falg = true;
                if (a != 0) {
                    if (b == 0) {
                        int temp = ints[ints.length - 1];
                        ints[ints.length - 1] = ints[b];
                        ints[b] = temp;
                        falg = false;
                    }
                    int temp = ints[0];
                    ints[0] = ints[a];
                    ints[a] = temp;
                }
                if (falg) {
                    if (b != ints.length - 1) {
                        int temp = ints[ints.length - 1];
                        ints[ints.length - 1] = ints[b];
                        ints[b] = temp;
                    }
                }
            }
        }
        return ints;
    }
}
