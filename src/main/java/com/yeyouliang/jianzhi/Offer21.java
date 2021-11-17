package com.yeyouliang.jianzhi;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/25 : 14:49.
 */
public class Offer21 {
    /**
     * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
     * */
    public static void main(String[] args) {
        int[][] ints = {
                {1},
                {2},
                {1, 2},
                {2, 1},
                {1, 1},
                {2, 2},
                {1, 1, 1},
                {1, 1, 1, 1},
                {2, 2, 2},
                {2, 2, 2, 2},
                {1, 2, 3},
                {1, 3, 2},
                {2, 1, 3},
                {2, 3, 1},
                {3, 1, 2},
                {3, 2, 1},
                {1, 2, 3, 4},
                {1, 2, 3, 3},
                {2, 1, 2, 5, 3, 2},
                {5, 1, 5, 2, 5, 3, 5, 4},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(exchange(anInt)));
        }
    }

    private static int[] exchange(int[] nums) {
        if (nums.length > 1) {
            int a = 0;
            int b = nums.length - 1;
            while (a < b) {
                while (nums[a] % 2 == 1) {
                    a++;
                    if (a == nums.length) {
                        break;
                    }
                }
                while (nums[b] % 2 == 0) {
                    b--;
                    if (b == -1) {
                        break;
                    }
                }
                if (a < b) {
                    int c = nums[a];
                    nums[a] = nums[b];
                    nums[b] = c;
                    a++;
                    b--;
                } else {
                    break;
                }
            }
        }
        return nums;
    }
}
