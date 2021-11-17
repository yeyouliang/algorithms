package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/20 : 17:08.
 */
public class ShuffleTheArray {
    /**
     * 1470. 重新排列数组
     * */
    public static void main(String[] args) {
        int[][][] ints = {
                {{2, 5, 1, 3, 4, 7}, {3}},
                {{1, 2, 3, 4, 4, 3, 2, 1}, {4}},
                {{1, 1, 2, 2}, {2}},
        };
        for (int[][] string : ints) {
            System.out.println(Arrays.toString(string[0]));
            System.out.println(Arrays.toString(string[1]));
            System.out.println(Arrays.toString(shuffle(string[0], string[1][0])));
            System.out.println("--------------------------");
        }
    }

    private static int[] shuffle(int[] nums, int n) {
        if (nums.length > 2) {
            int[] ints = new int[nums.length];
            int index = 0;
            for (int i = 0; i < n; i++) {
                ints[index++] = nums[i];
                ints[index++] = nums[n + i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = ints[i];
            }
            //System.arraycopy(ints, 0, nums, 0, nums.length);
        }
        return nums;
    }
}
