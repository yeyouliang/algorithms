package com.yeyouliang.ti;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/22 : 22:17.
 */
public class T25 {
    public static void main(String[] args) {
        int[][][] ints = {
                {{1}, {0}},
                {{0}, {0}},
                {{1}, {1}},
                {{0}, {1}},
                {{1}, {2}},
                {{0}, {2}},
                {{1, 0, 0, 0, 1}, {0}},
                {{1, 0, 0, 0, 1}, {1}},
                {{1, 0, 0, 0, 1}, {2}},
                {{0, 1, 0, 0, 0, 1}, {1}},
                {{0, 0, 1, 0, 0, 0, 1}, {1}},
                {{1, 0, 0, 0, 1, 0}, {1}},
                {{1, 0, 0, 0, 1, 0, 0}, {1}},
                {{1, 0, 0, 0, 1}, {2}},
                {{0, 1, 0, 0, 0, 1}, {2}},
                {{0, 0, 1, 0, 0, 0, 1}, {2}},
                {{1, 0, 0, 0, 1, 0}, {2}},
                {{1, 0, 0, 0, 1, 0, 0}, {2}},
        };
        for (int[][] string : ints) {
            System.out.println(Arrays.toString(string[0]));
            System.out.println(Arrays.toString(string[1]));
            System.out.println(Arrays.toString(m1(string[0], string[1][0])));
            System.out.println("---------------------------------");
        }
    }

    /**
     * 有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
     */
    private static int[] m1(int[] ints, int num) {
        if (ints != null) {
            if (ints.length == 0) {
                ints = new int[]{num};
            } else {
                int a = ints.length - 1;
                int b = ints[a];
                if (b != num) {
                    ints[a] = num;
                    if (b > num) {
                        for (int i = a - 1; i >= 0; i--) {
                            int c = ints[i];
                            int d = ints[i + 1];
                            if (c > d) {
                                ints[i] = d;
                                ints[i + 1] = c;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return ints;
    }
}
