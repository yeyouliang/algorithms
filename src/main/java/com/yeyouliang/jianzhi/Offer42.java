package com.yeyouliang.jianzhi;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/26 : 14:27.
 */
public class Offer42 {
    /**
     * 剑指 Offer 42. 连续子数组的最大和
     * */
    public static void main(String[] args) {
        int[][] nums = {{-2, 1, -3, 4, -1, 2, 1, -5, 4},{5,4,-1,7,8},{8,-19,5,-4,20},{1,2,-1,-2,2,1,-2,1,4,-5,4}};
        //int[][] nums = {{1,2,-1,-2,2,1,-2,1,4,-5,4}};
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num) + "," + maxSubarray(num));
        }
    }

    private static int maxSubarray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] ints = new int[nums.length];
        int b = nums[0];
        ints[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= 0) {
                b += nums[i];
                ints[i] = Math.max(nums[i], ints[i - 1]);
            } else {
                if (b <= 0) {
                    ints[i] = Math.max(nums[i], ints[i - 1]);
                    b=nums[i];
                } else {
                    ints[i] = Math.max(nums[i] + b, ints[i - 1]);
                    b = nums[i] + b;
                }
            }
        }
        return ints[ints.length - 1];
    }
}
