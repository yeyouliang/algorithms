package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/8/10 : 21:11.
 */
public class IntegerBreak {
    /**
     * 343. 整数拆分
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     * 示例 1:
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1。
     * 示例 2:
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
     * 说明: 你可以假设 n 不小于 2 且不大于 58。
     * */
    public static void main(String[] args) {
        int n = 58;
        System.out.println(integerBreak(n));
    }

    private static int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else {
            int[] ints = new int[n - 2 + 1];
            ints[0] = 2;
            ints[1] = 3;
            for (int i = 4; i <= n; i++) {
                int max = ints[i - 1 - 2];
                int half = i / 2;
                if (i % 2 == 1) {
                    half += 1;
                }
                for (int j = i - 2; j >= half; j--) {
                    max = Math.max(ints[j - 2] * ints[(i - j) - 2], max);
                }
                ints[i - 2] = max;
            }
            return ints[ints.length - 1];
        }
    }
}
