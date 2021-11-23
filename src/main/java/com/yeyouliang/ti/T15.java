package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/22 : 22:02.
 */
public class T15 {
    public static void main(String[] args) {
        m1(1);
        m1(2);
        m1(3);
        m1(4);
        m1(5);
        m1(6);
        m1(7);
        m1(8);
        m1(9);
        m1(10);
    }

    /**
     * 一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
     */
    private static void m1(int a) {
        double c = (double) 100;
        double d = 0;
        double e = 0;
        for (int i = 0; i < a; i++) {
            double f = c + d + e;
            c /= 2;
            e = c;
            d = f;
        }
        System.out.println(d + "-" + c);
    }
}
