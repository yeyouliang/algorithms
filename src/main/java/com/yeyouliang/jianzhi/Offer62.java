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
     */
    public static void main(String[] args) {
        int[][] ints = {
                {5, 3},
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
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int a = m % n;
            int b = a == 0 ? n - 1 : a - 1;
            while (true) {
                int c;
                if (b == list.size() - 1) {
                    c = 0;
                } else {
                    c = b;
                }
                list.remove(b);
                if (list.size() == 1) {
                    break;
                }
                a = m % list.size();
                int e = a == 0 ? list.size() - 1 : a - 1;
                int d = e + c;
                b = d > list.size() - 1 ? d - list.size() : d;
            }
            return list.get(0);
        }
    }
}
