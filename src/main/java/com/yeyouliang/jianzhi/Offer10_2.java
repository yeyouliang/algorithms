package com.yeyouliang.jianzhi;

import java.math.BigInteger;

/**
 * Created by YYL on 2021/10/24 : 18:13.
 */
public class Offer10_2 {
    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     * */
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 44, 46, 92, 100};
        for (int anInt : ints) {
            System.out.println(anInt + ":" + numWays(anInt));
        }
    }

    private static int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        BigInteger[] steps = {new BigInteger("1"), new BigInteger("2")};
        for (int i = 3; i <= n; i++) {
            BigInteger a = steps[0].add(steps[1]);
            steps[0] = steps[1];
            steps[1] = a;
        }
        return steps[1].mod(new BigInteger("1000000007")).intValue();
    }
}
