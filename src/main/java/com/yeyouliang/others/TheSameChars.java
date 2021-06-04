package com.yeyouliang.others;

/**
 * Created by YYL on 2021/5/15 : 21:35.
 */
public class TheSameChars {
    /**
     * 判断两个字符串是否由相同的字符组成
     * 问题描述：由相同的字符组成是指组成两个字符串的字母以及各个字母的个数是一样的，只是排列顺序不同而已，例如，"aaaabbc"与"abcbaaa"就由相同的字符组
     */
    public static void main(String[] args) {
        String a = "daaaabbc";
        String b = "abcbaaad";
        if (a.length() == b.length()) {
            for (char c : a.toCharArray()) {
                for (int i = 0; i < b.toCharArray().length; i++) {
                    if (c == b.charAt(i)) {
                        b = b.substring(0, i) + b.substring(i + 1, b.length());
                        break;
                    }
                }
            }
            if (b.length() == 0) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}
