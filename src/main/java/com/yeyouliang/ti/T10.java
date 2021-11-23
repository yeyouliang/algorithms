package com.yeyouliang.ti;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/22 : 18:28.
 */
public class T10 {
    public static void main(String[] args) {
        int[][] ints = {
                {1, 1, 1},
                {1, 1, 3},
                {3, 2, 3},
                {1, 2, 3},
                {1, 3, 2},
                {2, 1, 3},
                {2, 3, 1},
                {3, 1, 2},
                {3, 2, 1},
        };
        for (int[] anInt : ints) {
            System.out.print(Arrays.toString(anInt) + ":");
            m1(anInt);
        }
    }

    /**
     * 输入三个整数x,y,z，请把这三个数由小到大输出。
     */
    private static void m1(int[] anInt) {
        int a = anInt[0];
        int b = anInt[1];
        int c = anInt[2];
        if (a >= b) {
            if (c > a) {
                System.out.println(Arrays.toString(anInt) + ":" + b + "-" + a + "-" + c);
            } else if (c > b) {
                System.out.println(Arrays.toString(anInt) + ":" + b + "-" + c + "-" + a);
            } else {
                System.out.println(Arrays.toString(anInt) + ":" + c + "-" + b + "-" + a);
            }
        } else {//a<b
            if (c > b) {
                System.out.println(Arrays.toString(anInt) + ":" + a + "-" + b + "-" + c);
            } else if (c > a) {
                System.out.println(Arrays.toString(anInt) + ":" + a + "-" + c + "-" + b);
            } else {
                System.out.println(Arrays.toString(anInt) + ":" + c + "-" + a + "-" + b);
            }
        }
    }
}
