package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/6 : 21:35.
 */
public class FindTheDifference {
    /**
     * 389. 找不同
     * */
    public static void main(String[] args) {
        String[][] strings = {
                {"abcd", "abcde"},
                {"", "y"},
                {"a", "aa"},
                {"ae", "aea"},
        };
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string) + ":" + findTheDifference(string[0], string[1]));
        }
    }

    private static char findTheDifference(String s, String t) {
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            count += t.charAt(i) - 96;
        }
        for (int i = 0; i < s.length(); i++) {
            count -= s.charAt(i) - 96;
        }
        return (char) (count + 96);
    }
}
