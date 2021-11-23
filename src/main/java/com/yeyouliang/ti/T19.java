package com.yeyouliang.ti;

import java.math.BigInteger;

/**
 * Created by YYL on 2021/11/22 : 22:09.
 */
public class T19 {
    public static void main(String[] args) {
        m1();
    }

    /**
     * 有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
     */
    private static void m1() {
        BigInteger[] ints = new BigInteger[22];
        ints[0] = new BigInteger("1");
        ints[1] = new BigInteger("1");
        for (int i = 2; i < ints.length; i++) {
            ints[i] = ints[i - 2].add(ints[i - 1]);
        }
        BigInteger u1 = ints[2];
        BigInteger d1 = ints[1];
        for (int i = 2; i < ints.length - 1; i++) {
            BigInteger u2 = ints[i + 1];
            BigInteger d2 = ints[i];
            System.out.println(ints[i + 1] + "," + ints[i]);
            if (d2.mod(d1).equals(new BigInteger("0"))) {
                BigInteger a = d2.divide(d1);
                u1 = u1.multiply(a).add(u2);
                d1 = d2;
            } else {
                BigInteger a = u1.multiply(d2);
                BigInteger b = d1.multiply(u2);
                BigInteger c = d1.multiply(d2);
                u1 = a.add(b);
                d1 = c;
            }
        }
        System.out.println(u1.toString() + "/" + d1.toString());
    }
}
