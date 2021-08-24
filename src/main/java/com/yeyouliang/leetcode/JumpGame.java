package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/8/24 : 20:37.
 */
public class JumpGame {
    /**
     * 55. 跳跃游戏
     * */
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {2, 3, 1, 1, 4},
                {3, 2, 1, 0, 4},
                {0},
                {1},
                {1,0},
                {2,0},
                {2,1,0},
                {0,1},
                {0,1,2},
                {0,4},
                {1,2},
                {2,1},
                {2,4,1},
                {2,1,0,0,1},
                {2,2,0,0,1},
                {2,3,0,0,1},
                {2,4,0,0,1},
                {2,1,0,0,0},
                {2,2,0,0,0},
                {2,3,0,0,0},
                {1,0,1,0,1},
                {2,0,2,0,2},
                {2,0,2,0,0},
                {2,0,2,0,2,0},
                {2,0,2,0,2,0,1}
        };
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num) + "," + canJump(num));
        }
    }

    public static boolean canJump(int[] nums) {
        boolean can = false;
        if (nums.length == 1) {
            can = true;
        } else {
            int a = nums[0];
            if (a >= nums.length - 1) {
                can = true;
            } else if (a == 0) {
                can = false;
            } else {
                breakOut:
                for (int i = 1; i < nums.length; i++) {
                    for (int j = a; j>=i; j--) {
                        if (nums[j] == 0) {
                            continue;
                        }
                        int b = j + nums[j];
                        if (b > a) {
                            if (b >= nums.length - 1) {
                                can = true;
                                break breakOut;
                            } else {
                                a = b;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return can;
    }
}
