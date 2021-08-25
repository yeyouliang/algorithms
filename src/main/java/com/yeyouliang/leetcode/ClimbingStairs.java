package com.yeyouliang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YYL on 2021/3/14 : 21:02.
 */
public class ClimbingStairs {

    /**
     * 70. 爬楼梯
     */
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int anInt : ints) {
            System.out.println(anInt+":"+climbStairs(anInt));
        }
    }

    private static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] steps = {1, 2};
        for (int i = 3; i <= n; i++) {
            int a = steps[0] + steps[1];
            steps[0] = steps[1];
            steps[1] = a;
        }
        return steps[1];
    }
}
