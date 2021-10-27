package com.yeyouliang.jianzhi;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/27 : 8:52.
 */
public class Offer57 {
    /**
     * 剑指 Offer 57. 和为s的两个数字
     */
    public static void main(String[] args) {
        int[][][] ints = {
                {{10, 15, 20, 22, 26, 29, 30, 31, 34, 41, 46, 47, 60}, {48}},
                {{9}, {9}},
                {{2}, {9}},
                {{1, 7}, {9}},
                {{4, 4}, {8}},
                {{4, 5}, {8}},
                {{5, 5}, {8}},
                {{2, 7}, {9}},
                {{2, 7, 11, 15}, {9}},
                {{10, 26, 30, 31, 47, 60}, {40}},
        };
        for (int[][] string : ints) {
            System.out.println(Arrays.toString(string[0]));
            System.out.println(Arrays.toString(string[1]));
            System.out.println(Arrays.toString(twoSum(string[0], string[1][0])));
            System.out.println("---------------------------------");
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] ints = new int[0];
        if (nums.length > 1) {
            int a = 0;
            int b = nums.length - 1;
            while (a < b) {
                if (nums[b] > target) {
                    b--;
                } else {
                    int c = nums[a];
                    int d = nums[b];
                    int e = c + d;
                    if (e == target) {
                        ints = new int[2];
                        ints[0] = c;
                        ints[1] = d;
                        break;
                    } else if (e > target) {
                        b--;
                    } else {
                        a++;
                    }
                }
            }
        }
        return ints;
    }
}
