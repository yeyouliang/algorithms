package com.yeyouliang.jianzhi;

import java.math.BigInteger;

/**
 * Created by YYL on 2021/10/24 : 17:53.
 */
public class Offer10_1 {
    /**
     * 剑指 Offer 10- I. 斐波那契数列
     * */
    public static void main(String[] args) {
        for (int i = 0; i < 21; i++) {
            System.out.println(i + ":" + fib(i));
        }
        System.out.println(fib(48));
        System.out.println(fib(100));
    }

    private static int fib(int n) {
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        if (n == 0) {
            return a.intValue();
        } else if (n == 1) {
            return b.intValue();
        } else {
            for (int i = 0; i < n - 1; i++) {
                BigInteger c = a.add(b);
                a = b;
                b = c;
            }
            return b.mod(new BigInteger("1000000007")).intValue();
        }
    }
}
