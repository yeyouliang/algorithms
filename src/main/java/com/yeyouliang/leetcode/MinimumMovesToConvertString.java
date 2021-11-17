package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/10/23 : 12:16.
 */
public class MinimumMovesToConvertString {
    /**
     * 2027. 转换字符串的最少操作次数
     * */
    public static void main(String[] args) {
        String[] strings = {
                "XOXXXXOX",
                "XXX",
                "XXOX",
                "OOOO",
        };
        for (String string : strings) {
            System.out.println(string + ":" + minimumMoves(string));
        }
    }

    private static int minimumMoves(String s) {
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'X') {
                a++;
                i += 2;
            }
        }
        return a;
    }
}
