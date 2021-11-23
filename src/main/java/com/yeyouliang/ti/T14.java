package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/22 : 18:39.
 */
public class T14 {
    /**
     * 一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3。
     * 找出a以内的所有完数。
     */
    public static void main(String[] args) {
        int a = 100;
        for (int i = 1; i < a; i++) {
            m1(i);
        }
    }

    private static void m1(int a) {
        int b = a / 2;
        int c = a - 1;
        for (int i = 2; i <= b; i++) {
            if (c < 0) {
                break;
            }
            if (a % i == 0) {
                c -= i;
            }
        }
        if (c == 0) {
            System.out.println(a);
        }
    }
}
