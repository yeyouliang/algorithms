package com.yeyouliang.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YYL on 2021/10/20 : 11:00.
 */
public class MakeTwoArraysEqualByReversingSubArrays {
    /**
     * 1460. 通过翻转子数组使两个数组相等
     * */
    public static void main(String[] args) {
        int[][][] ints = {
                {{1, 2, 3, 4}, {2, 4, 3, 1}},
                {{1, 2, 3, 4, 3}, {3, 2, 4, 3, 1}},
                {{7}, {7}},
                {{1, 12}, {12, 1}},
                {{3, 7, 9}, {3, 7, 11}},
                {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}},
        };
        for (int[][] string : ints) {
            System.out.println(Arrays.toString(string[0]));
            System.out.println(Arrays.toString(string[1]));
            System.out.println(canBeEqual(string[0], string[1]));
        }
    }

    private static boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> a = new HashMap<>();
        for (int i : target) {
            int b = 1;
            if (a.containsKey(i)) {
                b += a.get(i);
            }
            a.put(i, b);
        }
        for (int i : arr) {
            Integer c = a.get(i);
            if (c == null) {
                return false;
            } else {
                if (c == 1) {
                    a.remove(i);
                } else {
                    a.put(i, c - 1);
                }
            }
        }
        return a.isEmpty();
    }
}
