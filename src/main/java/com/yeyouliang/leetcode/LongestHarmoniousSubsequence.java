package com.yeyouliang.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YYL on 2021/10/10 : 11:18.
 */
public class LongestHarmoniousSubsequence {
    /**
     * 594. 最长和谐子序列
     */
    public static void main(String[] args) {
        int[][] ints = {
                {1, 3, 2, 2, 5, 2, 3, 7},
                {1, 2, 3, 4},
                {1, 1, 1, 1},
                {1, 1, 2, 2, 3, 3},
                {1, 1, 2, 3},
                {1, 1},
                {1, 2},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + findLHS(anInt));
        }
    }

    private static int findLHS(int[] nums) {
        int length = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer a = map.get(num - 1);
            int b = map.get(num) == null ? 0 : map.get(num);
            Integer c = map.get(num + 1);
            if (a != null) {
                length = Math.max(a + b + 1, length);
            }
            if (c != null) {
                length = Math.max(b + c + 1, length);
            }
            map.put(num, b + 1);
        }
        return length;
    }
}
