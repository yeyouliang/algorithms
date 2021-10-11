package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/11 : 20:48.
 */
public class CanPlaceFlowers {
    /**
     * 605. 种花问题
     * */
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
                {{0,1, 0, 0, 0, 1}, {1}},
                {{0,0,1, 0, 0, 0, 1}, {1}},
                {{1, 0, 0, 0, 1,0}, {1}},
                {{1, 0, 0, 0, 1,0,0}, {1}},
                {{1, 0, 0, 0, 1}, {2}},
                {{0,1, 0, 0, 0, 1}, {2}},
                {{0,0,1, 0, 0, 0, 1}, {2}},
                {{1, 0, 0, 0, 1,0}, {2}},
                {{1, 0, 0, 0, 1,0,0}, {2}},
        };
        for (int[][] string : ints) {
            System.out.println(Arrays.toString(string[0]));
            System.out.println(Arrays.toString(string[1]));
            System.out.println(canPlaceFlowers(string[0], string[1][0]));
        }
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n > 0) {
            int length = flowerbed.length;
            int index = 0;
            while (n > 0 && index < length) {
                if (flowerbed[index] == 0) {
                    if (index - 1 < 0 && index + 1 == length) {
                        n--;
                    } else {
                        int a = 0;
                        if (index != 0) {
                            if (flowerbed[index - 1] == 0) {
                                a++;
                            } else {
                                a += 2;
                            }
                        } else {
                            a += 3;
                        }
                        if (a != 2) {
                            int b = 0;
                            if (index != length - 1) {
                                if (flowerbed[index + 1] == 0) {
                                    b++;
                                } else {
                                    b += 2;
                                }
                            } else {
                                b += 3;
                            }
                            if (b != 2) {
                                flowerbed[index] = 1;
                                n--;
                            }
                        }
                    }
                }
                index++;
            }
        }
        return n == 0;
    }
}
