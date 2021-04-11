package com.yeyouliang.others;

/**
 * Created by YYL on 2021/4/10 : 21:49.
 */
public class WalkGrid {

    /**
     * 走方格
     * 有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，
     * 最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
     * 给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
     * 测试样例：
     * [[1,2,3],
     * [1,1,1]
     * ],2,3
     * 返回：4
     */
    public static void main(String[] args) {
        int[][] ints = {
                {1, 2, 3},
                {1, 1, 1}
        };
        System.out.println(wg(ints));
    }

    public static int wg(int[][] ints) {
        int[][] length = new int[ints.length][ints[0].length];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                int tmp = ints[i][j];
                if (i == 0 && j == 0) {
                    length[i][j] = tmp;
                } else {
                    if (i == 0) {
                        length[i][j] = length[i][j - 1] + tmp;
                    } else if (j == 0) {
                        length[i][j] = length[i - 1][j] + tmp;
                    } else {
                        length[i][j] = Math.min(length[i][j - 1], length[i - 1][j]) + tmp;
                    }
                }
            }
        }
        return length[ints.length - 1][ints[0].length - 1];
    }
}
