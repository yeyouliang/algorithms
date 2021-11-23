package com.yeyouliang.ti;

import java.math.BigInteger;

/**
 * Created by YYL on 2021/11/22 : 22:10.
 */
public class T20 {
    public static void main(String[] args) {
        m1();
    }

    /**
     * 求1+2!+3!+...+20!的和。
     */
    private static void m1() {
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        for (int i = 2; i <= 20; i++) {
            BigInteger c = new BigInteger("" + i);
            b = b.multiply(c);
            a = a.add(b);
        }
        System.out.println(a.toString());
    }
}
