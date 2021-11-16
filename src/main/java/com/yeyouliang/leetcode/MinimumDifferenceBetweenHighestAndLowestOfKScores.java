package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/10/21 : 17:13.
 */
public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    /**
     * 1984. 学生分数的最小差值
     * */
    public static void main(String[] args) {
        int[][][] ints = {
                {{90}, {1}},
                {{9, 4, 1, 7}, {2}},
                {{9, 7, 5, 5}, {2}},
                {{9, 7, 5, 5}, {3}},
                {{9, 7, 5, 5}, {4}},
        };
        for (int[][] string : ints) {
            System.out.println(minimumDifference(string[0], string[1][0]));
        }
    }

    private static int minimumDifference(int[] nums, int k) {
        if (nums.length > 1 && k > 1) {
            for (int i = 1; i < nums.length; i++) {
                int index = i;
                while (index > 0 && nums[index - 1] > nums[index]) {
                    int tmp = nums[index];
                    nums[index] = nums[index - 1];
                    nums[index - 1] = tmp;
                    index--;
                }
            }
            int a = Integer.MAX_VALUE;
            for (int i = 0; i <= nums.length - k; i++) {
                a = Math.min(nums[i + k - 1] - nums[i], a);
            }
            return a;
        }
        return 0;
    }
}
