package com.yeyouliang.jianzhi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YYL on 2021/10/26 : 10:58.
 */
public class Offer39 {
    /**
    * 剑指 Offer 39. 数组中出现次数超过一半的数字
    * */
    public static void main(String[] args) {
        int[][] ints = {
                {3},
                {3, 3},
                {3, 3, 3},
                {3, 3, 3, 3},
                {1, 3, 3},
                {1, 3, 3, 3},
                {2, 1, 2, 5, 2, 2},
                {5, 1, 5, 2, 5, 3, 5, 5},
                {1, 2, 3, 2, 2, 2, 5, 4, 2},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + majorityElement(anInt));
        }
    }

    private static int majorityElement(int[] nums) {
        int a = nums[0];
        if (nums.length > 2) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int b;
                if (map.containsKey(num)) {
                    b = map.get(num) + 1;
                    if (b == nums.length / 2 + 1) {
                        a = num;
                        break;
                    }
                } else {
                    b = 1;
                }
                map.put(num, b);
            }
        }
        return a;
    }
}
