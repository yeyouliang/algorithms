package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/2/2 : 20:44.
 */
public class RemoveElement {
    /**
     * 27. 移除元素
     * */
    public static void main(String[] args) {
        int[][][] ints = {
                {{0, 1, 2, 2, 3, 0, 4, 2}, {2}},
                {{0, 1, 2, 2, 3, 0, 4, 3}, {2}},
                {{0, 1, 2, 2, 3, 0, 4, 3}, {0}},
                {{0, 1, 2, 2, 3, 0, 4, 3}, {1}},
                {{3, 2, 2, 3}, {3}},
                {{3}, {3}},
                {{3}, {1}}
        };
        for (int[][] anInt : ints) {
            System.out.println(Arrays.toString(anInt[0]) + ":" + removeElement(anInt[0], anInt[1][0]));
        }
    }

    private static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (val == nums[i]) {
                if (i != nums.length - 1) {
                    System.arraycopy(nums, i + 1, nums, i + 1 - 1, nums.length - (i + 1));
                    nums[nums.length - 1] = val;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        if (nums[nums.length - 1] == val) {
            nums[nums.length - 1] = 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] == val) {
                    nums[nums.length - 1] += 1;
                } else {
                    break;
                }
            }
            return nums.length - nums[nums.length - 1];
        } else {
            return nums.length;
        }
    }
}
