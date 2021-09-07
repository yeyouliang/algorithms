package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/9/7 : 14:47.
 */
public class NextPermutation {
    /**
     * 31. 下一个排列
     * */
    public static void main(String[] args) {
        int[][] nums = {
                {3, 4, 4, 0},
                {3, 4, 4, 2},
                {3, 4, 4, 3},
                {3, 4, 4, 4},
                {3, 4, 4, 5},
                {3, 2, 3, 0},
                {3, 3, 3, 0},
                {3, 0, 3, 0},
                {3, 3, 0, 0},
                {3, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 2},
                {1, 0, 2, 2},
                {1, 0, 2, 1},
                {1, 0, 2, 3},
                {1, 1, 2, 3},
                {1, 4, 2, 3},
                {1, 2, 2, 3},
                {1, 2, 2, 2},
                {5, 8, 0},
                {8, 5, 0},
                {5, 5, 0},
                {5, 0, 0},
                {1, 0},
                {1, 1},
                {1, 2},
                {1}
        };
        for (int[] num : nums) {
            System.out.print(Arrays.toString(num) + ":");
            nextPermutation(num);
        }
    }

    private static void nextPermutation(int[] nums) {
        if (nums.length > 1) {
            for (int i = nums.length - 1; i >= 1; i--) {
                int a = nums[i];
                int b = nums[i - 1];
                if (a <= b) {
                    int index = -1;
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] > b) {
                            index = j;
                            break;
                        }
                    }
                    if (index == -1) {
                        nums[i - 1] = a;
                        nums[i] = b;
                        for (int k = i; k < nums.length - 1; k++) {
                            if (nums[k] > nums[k + 1]) {
                                int temp = nums[k + 1];
                                nums[k + 1] = nums[k];
                                nums[k] = temp;
                            }
                        }
                    } else {
                        int temp = nums[i - 1];
                        nums[i - 1] = nums[index];
                        nums[index] = temp;
                        break;
                    }
                } else {
                    nums[i - 1] = a;
                    nums[i] = b;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
