package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/22 : 22:12.
 */
public class T22 {

    public static void main(String[] args) {
        System.out.println(m1(10, 5));
    }

    /**
     * 有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。问第三个人，又说比第2人大两岁。问第2个人，说比第一个人大两岁。
     * 最后问第一个人，他说是10岁。请问第五个人多大？
     */
    private static int m1(int a, int b) {
        if (b == 1) {
            return a;
        } else {
            return 2 + m1(a, b - 1);
        }
    }

    /**
     * 有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。问第三个人，又说比第2人大两岁。问第2个人，说比第一个人大两岁。
     * 最后问第一个人，他说是10岁。请问第五个人多大？
     */
    private static int m2(int a, int b) {
        for (int i = 0; i < b; i++) {
            a += 2;
        }
        return a;
    }
}
