package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/22 : 18:31.
 */
public class T11 {
    /**
     * 一个整数，它加上100后是一个完全平方数，加上168又是一个完全平方数，请问该数是多少？
     */
    public static void main(String[] args) {
        int[] ints = new int[1000];
        for (int i = 1; i < ints.length; i++) {
            int a = i * i;
            int c = a - 168;
            for (int j = i - 1; j >= 0; j--) {
                if (ints[j] == c) {
                    System.out.println(ints[j] - 100);
                } else if (c < 0) {
                    break;
                }
            }
            ints[i] = a;
        }
    }
}
