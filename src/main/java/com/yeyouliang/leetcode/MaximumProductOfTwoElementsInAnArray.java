package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/20 : 14:10.
 */
public class MaximumProductOfTwoElementsInAnArray {
    /**
     * 1464. 数组中两元素的最大乘积
     * */
    public static void main(String[] args) {
        int[][] ints = {
                {3, 4, 5, 2},
                {1, 5, 4, 5},
                {3, 7},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + maxProduct(anInt));
            System.out.println("-------------");
        }
    }

    private static int maxProduct(int[] nums) {
        int a;
        int b;
        if (nums[0] >= nums[1]) {
            a = nums[1];
            b = nums[0];
        } else {
            a = nums[0];
            b = nums[1];
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= b) {
                a = b;
                b = nums[i];
            } else if (nums[i] >= a) {
                a = nums[i];
            }
        }
        return (a - 1) * (b - 1);
    }
}
