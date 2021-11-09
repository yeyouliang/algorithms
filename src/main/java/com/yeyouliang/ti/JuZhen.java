package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/8 : 22:48.
 */
public class JuZhen {
    /**
     * 打印矩阵
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * */
    public static void main(String[] args) {
        int[][][] ints = {
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}},
                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
                {{1, 2}, {3, 4}},
                {{1}},
                {{1, 2}},
                {{1}, {2}},
                {{1, 2}, {3, 4}},
                {{1, 2, 3}, {5, 6, 7}},
                {{1, 2}, {3, 4}, {5, 6}},
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}},
                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
        };
        for (int[][] string : ints) {
            jz(string);
            System.out.println();
        }
    }

    private static void jz(int[][] ints) {
        if (ints != null && ints.length > 0) {
            int a = ints.length;
            int b = ints[0].length;
            int us = 0;
            int ue = b - 2;
            int uy = 0;
            int rs = 0;
            int re = a - 2;
            int rx = b - 1;
            int ds = b - 1;
            int de = 1;
            int dy = a - 1;
            int ls = a - 1;
            int le = 1;
            int lx = 0;
            while (true) {
                if (us > ue) {
                    break;
                }
                for (int i = us; i <= ue; i++) {
                    System.out.print(ints[uy][i] + ",");
                }
                if (rs > re) {
                    break;
                }
                for (int i = rs; i <= re; i++) {
                    System.out.print(ints[i][rx] + ",");
                }
                for (int i = ds; i >= de; i--) {
                    System.out.print(ints[dy][i] + ",");
                }
                for (int i = ls; i >= le; i--) {
                    System.out.print(ints[i][lx] + ",");
                }
                us++;
                ue--;
                uy++;
                rs++;
                re--;
                rx--;
                ds--;
                de++;
                dy--;
                ls--;
                le++;
                lx++;
            }
        }
    }
}
