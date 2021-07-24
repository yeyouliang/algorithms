package com.yeyouliang.lanqiao;

import java.util.Arrays;

/**
 * Created by YYL on 2021/7/24 : 10:14.
 */
public class LookForCoin {
    /**
     * 找假币
     * 在8枚硬币中，有1枚假币，假币外观与真币一模一样，只是重量略轻或略重一点。
     * 给你一架天平，要求最多称3次，就找出假币，并且知道它是重一些还是轻一些。
     */
    public static void main(String[] args) {
        int[][] ints = {
                {4, 4, 4, 4, 4, 4, 4, 3},
                {4, 4, 4, 4, 4, 4, 3, 4},
                {4, 4, 4, 4, 4, 3, 4, 4},
                {4, 4, 4, 4, 3, 4, 4, 4},
                {4, 4, 4, 3, 4, 4, 4, 4},
                {4, 4, 3, 4, 4, 4, 4, 4},
                {4, 3, 4, 4, 4, 4, 4, 4},
                {3, 4, 4, 4, 4, 4, 4, 4},
                {4, 4, 4, 4, 4, 4, 4, 5},
                {4, 4, 4, 4, 4, 4, 5, 4},
                {4, 4, 4, 4, 4, 5, 4, 4},
                {4, 4, 4, 4, 5, 4, 4, 4},
                {4, 4, 4, 5, 4, 4, 4, 4},
                {4, 4, 5, 4, 4, 4, 4, 4},
                {4, 5, 4, 4, 4, 4, 4, 4},
                {5, 4, 4, 4, 4, 4, 4, 4}};
        for (int[] anInt : ints) {
            compare(anInt);
        }
    }

    private static void compare(int[] ints) {
        System.out.print(Arrays.toString(ints));
        int a = ints[0];
        int b = ints[1];
        int c = 0;
        for (int i = 2; i < 5; i++) {
            c += ints[i];
        }
        int d = 0;
        for (int i = 5; i < 8; i++) {
            d += ints[i];
        }
        //第一次比较：第3位到第5位的和与第6位到第8位的和
        if (c == d) {
            //第二次比较
            if (a < ints[2]) {
                System.out.println("xiao");
            } else if (a > ints[2]) {
                System.out.println("da");
            } else {
                //第三次比较
                if (b < ints[2]) {
                    System.out.println("xiao");
                } else if (b > ints[2]) {
                    System.out.println("da");
                } else {
                    System.out.println("error");
                }
            }
        } else if (c < d) {
            int e = ints[2] + ints[3];
            int f = ints[3] + ints[4];
            //第二次比较和第三次比较
            if (e == a + b && f == a + b) {
                System.out.println("da");
            } else {
                System.out.println("xiao");
            }
        } else if (d < c) {
            int e = ints[5] + ints[6];
            int f = ints[6] + ints[7];
            //第二次比较和第三次比较
            if (e == a + b && f == a + b) {
                System.out.println("da");
            } else {
                System.out.println("xiao");
            }
        }
    }
}
