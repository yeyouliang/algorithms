package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/22 : 17:28.
 */
public class MaximumDifferenceBetweenIncreasingElements {
    /**
     * 2016. 增量元素之间的最大差值
     * */
    public static void main(String[] args) {
        int[][] ints = {
                {7, 1},
                {1, 7},
                {1, 2, 3, 4},
                {1, 2, 3, 3},
                {1, 2, 2, 4},
                {2, 2, 2, 4},
                {3, 2, 2, 4},
                {7, 1, 5, 4},
                {9, 4, 3, 2},
                {1, 5, 2, 10},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + maximumDifference(anInt));
        }
    }

    private static int maximumDifference(int[] nums) {
        int a = Integer.MAX_VALUE;
        if (nums[0] < nums[1]) {
            a = nums[1] - nums[0];
        }
        int b = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > b) {
                a = Math.max(nums[i] - b, a == Integer.MAX_VALUE ? -1 : a);
            } else if (nums[i] < b) {
                b = nums[i];
            }
        }
        return a == Integer.MAX_VALUE ? -1 : a;
    }
}
