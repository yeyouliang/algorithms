package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/9/27 : 20:37.
 */
public class RepeatedSubstringPattern {
    /**
     * 459. 重复的子字符串
     * */
    public static void main(String[] args) {
        String[] strings = {
                "a",
                "aa",
                "ab",
                "abab",
                "ababa",
                "abc",
                "aba",
                "aab",
                "abcabcabcabc",
                "abaabcabcabc",
                "abcabeabcabc",
                "abcabcabeabc",
                "abcabcabcabe",
        };
        for (String string : strings) {
            System.out.println(string + ":" + repeatedSubstringPattern(string));
        }
    }

    private static boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        if (length != 1) {
            int half = length / 2;
            while (half > 0) {
                if (length % half == 0) {
                    String b = s.substring(0, half);
                    boolean c = true;
                    for (int i = 1; i < length / half; i++) {
                        boolean d = b.equals(s.substring(i * half, i * half + half));
                        if (!d) {
                            c = false;
                            break;
                        }
                    }
                    if (c) {
                        return true;
                    }
                }
                half--;
            }
        }
        return false;
    }
}
