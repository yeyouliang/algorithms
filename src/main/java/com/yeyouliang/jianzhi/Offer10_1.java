package com.yeyouliang.jianzhi;

/**
 * Created by YYL on 2021/10/24 : 17:53.
 */
public class Offer10_1 {
    /**
     * 剑指 Offer 10- I. 斐波那契数列
     */
    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            fib(i);
        }
        //System.out.println(fib(100));
        //System.out.println(fib(100));
    }

    private static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            long a = 0;
            long b = 1;
            long c = 1000000007;
            int m = 0;
            long[][] longs = new long[2][2];
            for (int i = 0; i < n - 1; i++) {
                if (b > c || m > 0) {
                    if (longs[0][0] + longs[0][1] == 0L) {
                        longs[0][0] = b % c;
                        longs[0][1] = b / c;
                        m++;
                    } else if (longs[1][0] + longs[1][1] == 0L) {
                        longs[1][0] = b % c;
                        longs[1][1] = b / c;
                        m++;
                    } else {
                        m++;
                        long d = longs[0][0] + longs[1][0];
                        long e;
                        long f = longs[0][1] + longs[1][1];
                        if (d >= c) {
                            e = d - c;
                            f++;
                        } else {
                            e = d;
                        }
                        longs[0][0] = longs[1][0];
                        longs[0][1] = longs[1][1];
                        longs[1][0] = e;
                        longs[1][1] = f;
                    }
                }
                long x = a + b;
                a = b;
                b = x;
            }
            System.out.println(n + ":" + a + ":" + b + ":" + (m > 2) + ":" + (m > 2 ? (int) (longs[0][0] + longs[1][0] >= c ? (longs[0][0] + longs[1][0] - c) : longs[0][0] + longs[1][0]) : (int) (b % c)));
            return m > 2 ? (int) (longs[0][0] + longs[1][0] >= c ? (longs[0][0] + longs[1][0] - c) : longs[0][0] + longs[1][0]) : (int) (b % c);
        }
    }
}
