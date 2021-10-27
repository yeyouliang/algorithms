package com.yeyouliang.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/10/27 : 8:52.
 */
public class Offer57 {
    /**
     * 剑指 Offer 57. 和为s的两个数字
     * */
    public static void main(String[] args) {
        int[][][] ints = {
                {{9}, {9}},
                {{2}, {9}},
                {{1, 7}, {9}},
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
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            for (int num : nums) {
                if (num < target) {
                    int c = target - num;
                    if (a.contains(num)) {
                        ints = new int[2];
                        ints[0] = num;
                        ints[1] = c;
                        break;
                    } else {
                        if (!a.contains(c)){
                            a.add(c);
                        }
                    }
                }
            }
        }
        return ints;
    }
}
