package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/22 : 22:10.
 */
public class T21 {
    public static void main(String[] args) {
        System.out.println(m1(5));
    }

    /**
     * 利用递归方法求5!。
     */
    private static int m1(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * m1(n - 1);
        }
    }
}
