package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/9/26 : 21:30.
 */
public class IslandPerimeter {
    /**
     * 463. 岛屿的周长
     * */
    public static void main(String[] args) {
        int[][][] ints = {
                {{1}, {1}, {1}, {0}, {1}, {1}},
                {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}},
                {{0, 1, 0, 1}, {0, 1, 0, 1}, {0, 1, 0, 1}, {0, 1, 1, 1}},
                {{0, 1, 0, 1}, {0, 1, 0, 1}, {0, 1, 1, 1}, {0, 1, 0, 1}},
                {{1}},
                {{1, 0}},
        };
        for (int[][] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + islandPerimeter(anInt));
        }
    }

    private static int islandPerimeter(int[][] grid) {
        int length = 0;
        int[] a = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int b = grid[i].length;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    if (a[j] != 0) {
                        a[j] = 0;
                        b--;
                    }
                } else {
                    length += 4;
                    if (j != 0 && grid[i][j - 1] == 1) {
                        length -= 2;
                    }
                    if (a[j] == 1) {
                        length -= 2;
                    }
                    a[j] = 1;
                }
            }
            if (b == 0) {
                break;
            }
        }
        return length;
    }
}
