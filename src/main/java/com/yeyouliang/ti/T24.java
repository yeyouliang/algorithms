package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/22 : 22:16.
 */
public class T24 {
    public static void main(String[] args) {
        int[][][] ints = {
                {{1}},
                {{1, 2}, {3, 4}},
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
                {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}},
        };
        for (int[][] anInt : ints) {
            System.out.println(m1(anInt));
        }
    }

    /**
     * 求一个正方形矩阵主对角线元素之和。
     */
    private static int m1(int[][] ints) {
        if (ints.length == 1) {
            return ints[0][0];
        } else {
            int a = 0;
            int b = ints.length - 1;
            int c = 0;
            while (true) {
                if (a > b) {
                    break;
                }
                if (a == b) {
                    c += ints[a][b];
                    break;
                }
                c += ints[a][a];
                c += ints[a][b];
                c += ints[b][a];
                c += ints[b][b];
                a++;
                b--;
            }
            return c;
        }
    }
}
