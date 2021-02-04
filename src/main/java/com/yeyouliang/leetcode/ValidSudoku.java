package com.yeyouliang.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by YYL on 2021/2/4 : 20:54.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        int[][] ints = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (ints[j][i] != 0) {
                    if (set.contains(ints[j][i])) {
                        System.out.println("列:" + i + ",err," + ints[j][i]);
                        return;
                    }
                    set.add(ints[j][i]);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (ints[i][j] != 0) {
                    if (set.contains(ints[i][j])) {
                        System.out.println("行:" + i + ",err," + ints[i][j]);
                        return;
                    }
                    set.add(ints[i][j]);
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Integer> set = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int g = ints[i + k][j + l];
                        if (g != 0) {
                            if (set.contains(g)) {
                                System.out.println("格:" + i + "-" + j + ",err:" + g);
                                return;
                            }
                            set.add(g);
                        }
                    }
                }
                System.out.println();
            }
        }
        System.out.println("no");
    }
}
