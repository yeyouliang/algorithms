package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/19 : 9:40.
 */
public class T4 {
    /**
     * 写一个函数去计算第n个斐波那契数？是否能用递归和非递归两种方法？
     */
    public static void main(String[] args) {
        System.out.println(m1(1, 1, 1, 1));
        System.out.println(m1(2, 2, 1, 1));
        System.out.println(m1(3, 3, 1, 1));
        System.out.println(m1(4, 4, 1, 1));
        System.out.println(m1(5, 5, 1, 1));
        System.out.println(m1(6, 6, 1, 1));
        System.out.println(m1(7, 7, 1, 1));
        System.out.println(m2(1));
        System.out.println(m2(2));
        System.out.println(m2(3));
        System.out.println(m2(4));
        System.out.println(m2(5));
        System.out.println(m2(6));
        System.out.println(m2(7));
    }

    /**
     * 递归
     *
     * @param a 第几个
     * @param b 索引，初始值与a相同
     * @param c 第一项
     * @param d 第二项
     */
    private static int m1(int a, int b, int c, int d) {
        if (a == 1 || a == 2) {
            return 1;
        } else {
            int e = c + d;
            if (b == 3) {
                return e;
            } else {
                return m1(a, b - 1, d, e);
            }
        }
    }

    /**
     * 非递归
     */
    private static int m2(int n) {
        int a = 1;
        int b = 1;
        if (n == 1) {
            return a;
        } else if (n == 2) {
            return b;
        } else {
            for (int i = 2; i < n; i++) {
                int c = a + b;
                a = b;
                b = c;
            }
            return b;
        }
    }
}
