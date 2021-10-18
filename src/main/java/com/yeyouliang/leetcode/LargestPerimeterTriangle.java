package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/18 : 14:30.
 */
public class LargestPerimeterTriangle {
    /**
     * 976. 三角形的最大周长
     * */
    public static void main(String[] args) {
        int[][] ints = {
                {2, 1, 2},
                {1, 2, 1},
                {1, 1, 1},
                {3, 2, 3, 4},
                {3, 6, 2, 3},
                {3, 6, 2, 3, 3},
                {3, 6, 2, 3, 6, 6},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + largestPerimeter(anInt));
        }
    }

    private static int largestPerimeter(int[] nums) {
        int a = 0;
        for (int i = 1; i < nums.length; i++) {
            int index = i;
            while (index > 0 && nums[index - 1] > nums[index]) {
                int tmp = nums[index];
                nums[index] = nums[index - 1];
                nums[index - 1] = tmp;
                index--;
            }
        }
        breakOut:
        for (int i = nums.length - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (nums[i] < nums[j] + nums[k]) {
                        a = nums[i] + nums[j] + nums[k];
                        break breakOut;
                    }
                }
            }
        }
        return a;
    }
}
