package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/8 : 22:48.
 */
public class JuZhen {
    /**
     * 打印矩阵
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     */
    public static void main(String[] args) {
        int[][][] ints = {
                {{1}},
                {{1, 2}},
                {{1}, {2}},
                {{1, 2}, {3, 4}},
                {{1, 2, 3}, {4, 5, 6}},
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
            int xs = 0;
            int xe = b - 1;
            int ys = 0;
            int ye = a - 1;
            while (true) {
                if (xs > xe) {
                    break;
                }
                if (xs == xe && ys == ye) {
                    if (xs >= 0 && ys >= 0) {
                        System.out.print(ints[xs][ys]);
                    }
                    break;
                }
                if (xs == xe) {
                    for (int i = ys; i <= ye; i++) {
                        System.out.print(ints[i][xs] + ",");
                    }
                    break;
                } else if (ys == ye) {
                    for (int i = xs; i <= xe; i++) {
                        System.out.print(ints[ys][i] + ",");
                    }
                    break;
                } else {
                    System.out.print(ints[ys][xs] + ",");
                    for (int i = xs + 1; i < xe; i++) {
                        System.out.print(ints[ys][i] + ",");
                    }
                    System.out.print(ints[ys][xe] + ",");
                    for (int i = ys + 1; i < ye; i++) {
                        System.out.print(ints[i][xe] + ",");
                    }
                    System.out.print(ints[ye][xe] + ",");
                    for (int i = xe - 1; i > xs; i--) {
                        System.out.print(ints[ye][i] + ",");
                    }
                    System.out.print(ints[ye][xs] + ",");
                    for (int i = ye - 1; i > ys; i--) {
                        System.out.print(ints[i][xs] + ",");
                    }
                    xs++;
                    xe--;
                    ys++;
                    ye--;
                }
            }
        }
    }
}
