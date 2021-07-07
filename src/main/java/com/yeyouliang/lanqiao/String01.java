package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/7/7 : 22:06.
 */
public class String01 {
    /**
     * 字串
     * 题目描述
     * 对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是
     * 00000
     * 00001
     * 00010
     * 00011
     * 00100
     * 请按从小到大的顺序输出这32种01串。
     * 输入
     * 无
     * 输出
     * 输出32行，按从小到大的顺序每行一个长度为5的01串。
     * 样例输出
     * 00000
     * 00001
     * 00010
     * 00011
     */
    public static void main(String[] args) {
        print("", 5);
    }

    private static void print(String s, int length) {
        if (s.length() == length) {
            System.out.println(s);
            return;
        }
        print(s + "0", length);
        print(s + "1", length);
    }
}
