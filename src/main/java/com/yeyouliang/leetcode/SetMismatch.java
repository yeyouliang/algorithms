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
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
    }

    private static int[] findErrorNums(int[] nums) {
        int[] ints = new int[2];
        for (int i = 1; i < nums.length; i++) {
            int index = i;
            while (index > 0 && nums[index - 1] > nums[index]) {
                int tmp = nums[index];
                nums[index] = nums[index - 1];
                nums[index - 1] = tmp;
                index--;
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                ints[0] = nums[i];
                ints[1] = nums[i] + 1;
                break;
            }
        }
        return ints;
    }
}
