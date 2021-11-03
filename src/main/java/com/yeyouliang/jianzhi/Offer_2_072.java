package com.yeyouliang.jianzhi;

/**
 * Created by YYL on 2021/11/1 : 11:43.
 */
public class Offer_2_072 {
    /**
     * 剑指 Offer II 072. 求平方根
     * */
    public static void main(String[] args) {
        //int[] ints = {123, 122, 121, 120, 119, 118, 117, 116, 115, 114, 113, 112, 111, 110, 109, 108, 107, 106, 105, 104, 103, 102, 101, 100, 99, 98};
        int[] ints = {Integer.MAX_VALUE, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        for (int anInt : ints) {
            System.out.println(anInt + ":" + mySqrt(anInt));
        }
    }

    private static int mySqrt(int x) {
        if (x < 2) {
            return x;
        } else {
            long a = 1;
            long b = x > 46341 ? 46341 : x;
            while (true) {
                long c = b - a;
                if (c == 1) {
                    return (int) a;
                }
                long d = c / 2;
                long e = a + d;
                if (e * e > x) {
                    b = e;
                } else if (e * e < x) {
                    a = e;
                } else {
                    return (int) e;
                }
            }
        }
    }
}
