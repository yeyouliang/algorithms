package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/9/5 : 14:45.
 */
public class SetMismatch {
    /**
     * 645. 错误的集合
     */
    public static void main(String[] args) {
        int[][] ints = {
                {1, 1},
                {2, 2},
                {2, 2, 3},
                {1, 2, 2, 4},
                {1, 2, 4, 2},
                {1, 4, 2, 2},
                {2, 4, 2, 1},
                {2, 4, 1, 2},
                {2, 2, 4, 1},
                {2, 2, 1, 4},
                {2, 1, 2, 4},
                {2, 1, 4, 2},
                {4, 2, 2, 1},
                {4, 2, 1, 2},
                {4, 1, 2, 2},
                {4, 1, 2, 3, 4},
                {4, 1, 2, 2, 5},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(findErrorNums(anInt)));
        }
    }

    private static int[] findErrorNums(int[] nums) {
        int[] ints = new int[nums.length];
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = ints[nums[i] - 1];
            if (c == 0) {
                ints[nums[i] - 1] = nums[i];
            } else {
                a = nums[i];
            }
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                b = i + 1;
                break;
            }
        }
        return new int[]{a,b};
    }
}
