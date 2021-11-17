package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/2 : 18:33.
 */
public class StringRotationLcci {
    /**
     * 面试题 01.09. 字符串轮转
     * */
    public static void main(String[] args) {
        String[][] strings = {
                {"a", "a"},
                {"a", "b"},
                {"a", "aa"},
                {"a", "ab"},
                {"ab", "ab"},
                {"ab", "ac"},
                {"ab", "ba"},
                {"abc", "abc"},
                {"abc", "bca"},
                {"abc", "cab"},
                {"abc", "caa"},
                {"waterbottle", "erbottlewat"},
                {"aa", "aba"},
        };
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string) + ":" + isFlipedString(string[0], string[1]));
        }
    }

    private static boolean isFlipedString(String s1, String s2) {
        if (s1.length() == s2.length()) {
            if (s1.length() > 0) {
                StringBuilder sb1 = new StringBuilder();
                for (int i = 0; i < s2.length(); i++) {
                    if (s1.charAt(0) == s2.charAt(i)) {
                        int c = 0;
                        int d = i;
                        boolean e = true;
                        StringBuilder sb2 = new StringBuilder();
                        while (d < s2.length()) {
                            if (s1.charAt(c) != s2.charAt(d)) {
                                e = false;
                                break;
                            }
                            sb2.append(s2.charAt(d));
                            c++;
                            d++;
                        }
                        if (e && s1.equals(sb2.toString() + sb1.toString())) {
                            return true;
                        }
                    }
                    sb1.append(s2.charAt(i));
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
