package com.yeyouliang.array;

import java.util.Arrays;

/**
 * Created by YYL on 2021/8/22 : 13:53.
 */
public class HalfSearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12, 15, 16, 19}, 14));
    }

    private static boolean search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target;
        }
        int half = nums.length / 2;
        return search(Arrays.copyOfRange(nums, 0, half), target) || search(Arrays.copyOfRange(nums, half, nums.length), target);
    }
}
