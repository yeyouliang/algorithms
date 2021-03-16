package com.yeyouliang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YYL on 2021/3/14 : 21:02.
 */
public class ClimbingStairs {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？注意：给定 n 是一个正整数。
     * 样例
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     */
    public static void main(String[] args) {
        System.out.println(climbingStairs(10));
    }

    public static int climbingStairs(int n) {
        if (n < 3) {
            return n;
        }
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("0", n);
        while (true) {
            Map<String, Integer> m = new HashMap<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int diff = entry.getValue() - 1;
                if (entry.getValue() - 1 > 0) {
                    m.put(entry.getKey() + "-" + 1, diff);
                }
                if (entry.getValue() - 1 == 0) {
                    System.out.println(entry.getKey() + "--" + 1);
                    count++;
                }
                if (entry.getValue() - 2 > 0) {
                    m.put(entry.getKey() + "-" + 2, diff - 1);
                }
                if (entry.getValue() - 2 == 0) {
                    System.out.println(entry.getKey() + "--" + 2);
                    count++;
                }
            }
            if (m.isEmpty()) {
                return count;
            }
            map = m;
        }
    }
}
