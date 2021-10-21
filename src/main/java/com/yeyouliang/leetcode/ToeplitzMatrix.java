package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/10/21 : 9:57.
 */
public class ToeplitzMatrix {
    /**
     * 766. 托普利茨矩阵
     * */
    public static void main(String[] args) {
        int[][][] ints = {
                {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}},
                {{1, 2}, {2, 2}},
        };
        for (int[][] anInt : ints) {
            System.out.println(isToeplitzMatrix(anInt));
        }
    }

    private static boolean isToeplitzMatrix(int[][] matrix) {
        boolean falg = true;
        breakOut:
        for (int i = 1; i < matrix.length; i++) {
            int[] a = matrix[i - 1];
            int[] b = matrix[i];
            for (int j = 1; j < a.length; j++) {
                if (b[j] != a[j - 1]) {
                    falg = false;
                    break breakOut;
                }
            }
        }
        return falg;
    }
}
