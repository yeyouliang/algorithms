package com.yeyouliang.jianzhi;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/29 : 11:03.
 */
public class Offer_2_001 {
    /**
     * 剑指 Offer II 001. 整数除法
     */
    public static void main(String[] args) {
        int[][] ints = {
                {-2147483648, -1},
                {7, -3},
                {0, 1},
                {1, 1},
                {-17, 2},
                {-16, 2},
                {-15, 2},
                {-14, 2},
                {-13, 2},
                {-12, 2},
                {-11, 2},
                {-10, 2},
                {-9, 2},
                {-8, 2},
                {-7, 2},
                {-6, 2},
                {-5, 2},
                {-4, 2},
                {-3, 2},
                {-2, 2},
                {-1, 2},
                {0, 2},
                {1, 2},
                {2, 2},
                {3, 2},
                {4, 2},
                {5, 2},
                {6, 2},
                {7, 2},
                {8, 2},
                {9, 2},
                {10, 2},
                {11, 2},
                {12, 2},
                {13, 2},
                {14, 2},
                {15, 2},
                {16, 2},
                {17, 2},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + divide(anInt[0], anInt[1]));
        }
    }

    private static int divide(int a, int b) {
        if (a == 0) {
            return 0;
        } else {
            boolean zheng = (a < 0 && b < 0) || (a > 0 && b > 0);
            long c = Math.abs((long) a);
            long d = Math.abs((long) b);
            if (c < d) {
                return 0;
            } else if (a == b) {
                return 1;
            } else if (c == d) {
                return -1;
            } else if (d == 1L) {
                return zheng ? (a == Integer.MIN_VALUE ? Integer.MAX_VALUE : (a < 0 ? 0 - a : a)) : (a < 0 ? a : 0 - a);
            } else {
                long e = d;
                int g = 1;
                while (true) {
                    e = e + e;
                    g = g + g;
                    if (e == c) {
                        return zheng ? g : 0 - g;
                    } else if (e > c) {
                        while (true) {
                            e -= d;
                            g--;
                            if (e <= c) {
                                return zheng ? g : 0 - g;
                            }
                        }
                    }
                }
            }
        }
    }
}
