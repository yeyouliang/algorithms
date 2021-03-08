package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/3/8 : 21:51.
 */
public class SearchInsertPosition {
    /**
     * 输入: [1,3,5,6], 5
     * 输出: 2
     *
     * 输入: [1,3,5,6], 2
     * 输出: 1
     *
     * 输入: [1,3,5,6], 7
     * 输出: 4
     *
     * 输入: [1,3,5,6], 0
     * 输出: 0
     */
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (nums[0] <= target) {
            return 0;
        }
        if (nums[length - 1] == target) {
            return length - 1;
        }
        if (nums[length - 1] < target) {
            return length;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > target) {
                if (nums[i - 1] == target) {
                    return i - 1;
                }
                return i;
            }
        }
        return -1;
    }
}
