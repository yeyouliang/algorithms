package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/22 : 17:50.
 */
public class Convert1dArrayInto2dArray {
    /**
     * 2022. 将一维数组转变成二维数组
     */
    public static void main(String[] args) {
        int[][][] ints = {
                {{1, 1, 1, 1}, {4, 1}},
                {{1, 2, 3, 4}, {2, 2}},
                {{1, 2, 3}, {1, 3}},
                {{1, 2}, {1, 1}},
                {{3}, {1, 2}},
                {{1, 2, 3}, {2, 2}},
                {{1, 2}, {2, 2}},
                {{1}, {2, 2}},
        };
        for (int[][] string : ints) {
            System.out.println(Arrays.toString(string[0]));
            System.out.println(Arrays.toString(string[1]));
            int[][] in = construct2DArray(string[0], string[1][0], string[1][1]);
            System.out.println(in.length);
        }
    }

    private static int[][] construct2DArray(int[] original, int m, int n) {
        int[][] ints = new int[0][0];
        if (original.length == m * n) {
            ints = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ints[i][j] = original[n * i + j];
                }
            }
        }
        return ints;
        /*int[][] ints = new int[0][0];
        if (original.length <= m * n && original.length > (m - 1) * n) {
            int a = original.length;
            ints = new int[m][];
            for (int i = 0; i < m; i++) {
                int[] b = new int[a > n ? n : a];
                for (int j = 0; j < b.length; j++) {
                    b[j] = original[m * i + j];
                }
                ints[i] = b;
                a -= n;
            }
        }
        return ints;*/
    }
}
