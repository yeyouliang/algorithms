package com.yeyouliang.leetcode;

import java.util.*;

/**
 * Created by YYL on 2021/10/23 : 14:43.
 */
public class TwoOutOfThree {
    /**
     * 2032. 至少在两个数组中出现的值
     * */
    public static void main(String[] args) {
        int[][][] ints = {
                {{1}, {1}, {1}},
                {{1}, {1}, {3}},
                {{1}, {2}, {3}},
                {{1, 1, 3, 2}, {2, 3}, {3}},
                {{3, 1}, {2, 3}, {1, 2}},
                {{1, 2, 2}, {4, 3, 3}, {5}},
        };
        for (int[][] string : ints) {
            System.out.println(twoOutOfThree(string[0], string[1], string[2]));
            System.out.println("----------");
        }
    }

    private static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] a = new int[101];
        int[] b = new int[101];
        int[] c = new int[101];
        for (int i : nums1) {
            a[i] = 1;
        }
        for (int i : nums2) {
            b[i] = 1;
        }
        for (int i : nums3) {
            c[i] = 1;
        }
        List<Integer> d = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            if (a[i] + b[i] + c[i] > 1) {
                d.add(i);
            }
        }
        return d;
    }
}
