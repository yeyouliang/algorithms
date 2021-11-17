package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/21 : 14:31.
 */
public class FindGreatestCommonDivisorOfArray {
    /**
     * 1979. 找出数组的最大公约数
     * */
    public static void main(String[] args) {
        int[][] ints = {
                {10,6, 9,},
                {2, 5, 6, 9, 10},
                {7, 5, 6, 8, 3},
                {3, 3},
                {1, 1},
                {1, 1, 1},
                {1, 2},
                {1, 2, 2},
                {2, 1, 2},
                {2, 2, 1},
                {2, 1},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + findGCD(anInt));
        }
    }

    private static int findGCD(int[] nums) {
        int min = Math.min(nums[0], nums[1]);
        int max = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            }
        }
        if (max == min) {
            return max;
        } else {
            for (int i = min; i > 0; i--) {
                if (max % i == 0 && min % i == 0) {
                    return i;
                }
            }
        }
        return 1;
    }
}
