package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/1 : 18:04.
 */
public class CheckPermutationLcci {
    /**
     * 面试题 01.02. 判定是否互为字符重排
     * */
    public static void main(String[] args) {
        String[][] strings = {
                {"abc", "bca"},
                {"abc", "bad"},
                {"abc", "abd"},
        };
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string) + ":" + CheckPermutation(string[0], string[1]));
        }
    }

    private static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                String a = s1.substring(i, i + 1);
                int b = s2.indexOf(a);
                if (b == -1) {
                    break;
                } else {
                    s2 = s2.substring(0, b) + s2.substring(b + 1, s2.length());
                }
            }
            return s2.isEmpty();
        }
        return false;
    }
}
