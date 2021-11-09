package com.yeyouliang.ti;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/9 : 10:59.
 */
public class ArraySum {
    /**
     * 数组中连续元素的和
     * 给出一个排序好的数组和一个数，求数组中连续元素的和等于所给数的子数组
     * */
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] sums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
        for (int sum : sums) {
            int[] array = findArray(nums, sum);
            System.out.println(sum + ":" + (array == null ? "null" : Arrays.toString(array)));
        }
    }

    private static int[] findArray(int[] nums, int sum) {
        if (nums != null && nums.length > 0) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == sum) {
                    return new int[]{nums[i]};
                }
                if (nums[i] < sum) {
                    int a = 0;
                    for (int j = i; j >= 0; j--) {
                        a += nums[j];
                        if (a == sum) {
                            int[] array = new int[i - j + 1];
                            System.arraycopy(nums, j, array, 0, i - j + 1);
                            return array;
                        } else if (a > sum) {
                            break;
                        }
                    }
                }
            }
        }
        return new int[0];
    }
}
