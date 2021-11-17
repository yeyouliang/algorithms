package com.yeyouliang.jianzhi;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/26 : 14:35.
 */
public class Offer53 {
    /**
     * 剑指 Offer 53 - I. 在排序数组中查找数字 I
     * */
    public static void main(String[] args) {
        int[][][] ints = {
                {{1, 8}, {8}},
                {{8, 1}, {8}},
                {{1, 8, 8}, {8}},
                {{8, 1, 8}, {8}},
                {{8, 8, 1}, {8}},
                {{8, 8, 8}, {8}},
                {{2, 8, 8, 8}, {8}},
                {{8, 2, 8, 8}, {8}},
                {{8, 8, 2, 8}, {8}},
                {{8, 8, 8, 2}, {8}},
                {{2, 2, 8, 8}, {8}},
                {{8, 8, 8, 8}, {8}},
                {{8, 8, 8, 8, 8}, {8}},
                {{5, 7, 7, 8, 8, 10}, {8}},
                {{5, 7, 7, 8, 8, 10}, {6}},
                {{}, {8}},
                {{5}, {8}},
                {{5, 7}, {8}},
                {{5, 7, 9}, {8}},
                {{5, 7, 9, 9}, {8}},
                {{5, 7, 9, 9, 8}, {8}},
                {{5, 7, 9, 8, 9}, {8}},
                {{5, 7, 8, 8, 9}, {8}},
                {{5, 8, 9, 9, 9}, {8}},
                {{8, 7, 9, 9, 9}, {8}},
                {{5, 7, 9, 9, 9}, {8}},
                {{8}, {8}},
                {{8, 8}, {8}},
        };
        for (int[][] string : ints) {
            System.out.println(Arrays.toString(string[0]));
            System.out.println(Arrays.toString(string[1]));
            System.out.println(search(string[0], string[1][0]));
            System.out.println("---------------------");
        }

    }

    private static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0] == target ? 1 : 0;
        } else {
            int a = nums.length / 2;
            int[] left = new int[a];
            System.arraycopy(nums, 0, left, 0, a);
            int[] right = new int[nums.length - a];
            System.arraycopy(nums, a, right, 0, nums.length - a);
            int c = 0;
            c += search(left, target);
            c += search(right, target);
            return c;
        }
    }
}
