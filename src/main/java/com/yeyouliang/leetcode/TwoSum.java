package com.yeyouliang.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YYL on 2021/2/1 : 20:12.
 */
public class TwoSum {
    /**
     * 1. 两数之和
     * */
    public static void main(String[] args) {
        int[][][] nums = {
                {{2, 7, 11, 15}, {9}},
                {{3, 2, 4}, {6}},
                {{3, 3}, {6}}
        };
        for (int[][] num : nums) {
            System.out.println(Arrays.toString(num[0]) + "" + Arrays.toString(twoSum(num[0], num[1][0])));
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ints[0] = i;
                ints[1] = map.get(nums[i]);
                break;
            } else {
                int diff = target - nums[i];
                map.put(diff, i);
            }
        }
        return ints;
    }
}
