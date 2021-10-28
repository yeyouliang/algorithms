package com.yeyouliang.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/10/28 : 12:03.
 */
public class Offer62 {
    /**
     * 剑指 Offer 62. 圆圈中最后剩下的数字
     * */
    public static void main(String[] args) {
        int[][] ints = {
                {2, 1},
                {2, 2},
                {2, 3},
                {2, 4},
                {2, 5},
                {5, 5},
                {10, 17},
                {5, 1},
                {5, 2},
                {5, 3},
                {5, 4},
                {5, 6},
                {5, 7},
                {5, 8},
                {5, 9},
                {5, 10},
                {5, 11},
                {5, 12},
                {10, 17},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + lastRemaining(anInt[0], anInt[1]));
        }
    }

    private static int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        } else if (m == 1) {
            return n - 1;
        } else {
            int b = m % n;
            int a = b == 0 ? n - 1 : b - 1;
            List<Integer> list = new ArrayList<>();
            while (true) {
                if (list.size() == n - 1) {
                    break;
                }
                list.add(a);
                while (true) {
                    if (a == n - 1) {
                        a = 0;
                    } else {
                        a++;
                    }
                    if (!list.contains(a)) {
                        int d = m - 1;
                        int e = a;
                        while (d > 0) {
                            if (e == n - 1) {
                                e = 0;
                            } else {
                                e++;
                            }
                            if (!list.contains(e)) {
                                d--;
                            }
                        }
                        a = e;
                        break;
                    }
                }
            }
            return a;
        }
    }
}
