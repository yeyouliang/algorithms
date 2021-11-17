package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/18 : 15:37.
 */
public class SquaresOfASortedArray {
    /**
     * 977. 有序数组的平方
     */
    public static void main(String[] args) {
        int[][] ints = {
                {-4},
                {0},
                {4},
                {-9, 0},
                {-9, 1},
                {-9, 10},
                {0, 1},
                {1, 3},
                {-4, -1, 0, 3, 10},
                {-7, -3, 2, 3, 11},
                {1, 2, 3, 3},
                {2, 1, 2, 5, 3, 2},
                {5, 1, 5, 2, 5, 3, 5, 4},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(sortedSquares(anInt)));
        }
    }

    private static int[] sortedSquares(int[] nums) {
        int[] ints = new int[nums.length];
        if (nums.length == 1) {
            ints[0] = nums[0] * nums[0];
        } else {
            int start = 0;
            int end = nums.length - 1;
            int index = end;
            while (true) {
                int a = nums[end] * nums[end];
                int b = nums[start] * nums[start];
                if (start == end) {
                    ints[index] = a;
                    break;
                }
                if (a >= b) {
                    ints[index] = a;
                    end--;
                } else {
                    ints[index] = b;
                    start++;
                }
                index--;
            }
        }
        return ints;
    }
}
