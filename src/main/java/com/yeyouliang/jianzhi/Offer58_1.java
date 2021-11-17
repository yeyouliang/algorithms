package com.yeyouliang.jianzhi;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/27 : 14:25.
 */
public class Offer58_1 {
    /**
     * 剑指 Offer 58 - II. 左旋转字符串
     * */
    public static void main(String[] args) {
        String[][] strings = {
                {"abcdefg", "1"},
                {"abcdefg", "2"},
                {"abcdefg", "3"},
                {"abcdefg", "4"},
                {"abcdefg", "5"},
                {"abcdefg", "6"},
                {"lrloseumgh", "6"},
        };
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string) + ":" + reverseLeftWords(string[0], Integer.parseInt(string[1])));
        }
    }

    private static String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s.substring(i, i+1));
        }
        String b = s.substring(n, s.length());
        return b + sb.toString();
    }
}
