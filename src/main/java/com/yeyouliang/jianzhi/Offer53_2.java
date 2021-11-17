package com.yeyouliang.jianzhi;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/26 : 18:28.
 */
public class Offer53_2 {
    /**
     * 剑指 Offer 53 - II. 0～n-1中缺失的数字
     * */
    public static void main(String[] args) {
        int[][] ints = {
                {0},
                {1},
                {0, 1},
                {0, 2},
                {1, 2},
                {0, 1, 2},
                {0, 1, 3},
                {1, 2, 3},
                {0, 2, 3},
                {0, 1, 2, 3, 4, 5, 6, 7, 9},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + missingNumber(anInt));
        }
    }

    private static int missingNumber(int[] nums) {
        int a;
        if (nums[0] != 0) {
            a = 0;
        } else if (nums.length == 1) {
            a = 1;
        } else {
            a = nums.length;
            int b = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - b > 1) {
                    a = b + 1;
                    break;
                } else {
                    b = nums[i];
                }
            }
        }
        return a;
    }
}
