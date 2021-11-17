package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/20 : 22:17.
 */
public class CheckIfStringIsAPrefixOfArray {
    /**
     * 1961. 检查字符串是否为数组前缀
     * */
    public static void main(String[] args) {
        String[][][] strings = {
                {{"z"}, {"z"}},
                {{"ccccccccc"}, {"c", "cc"}},
                {{"iloveleetcode"}, {"i", "love", "leetcode", "apples"}},
                {{"iloveleetcode"}, {"apples", "i", "love", "leetcode"}},
        };
        for (String[][] string : strings) {
            System.out.println(Arrays.toString(string[0]));
            System.out.println(Arrays.toString(string[1]));
            System.out.println(isPrefixString(string[0][0], string[1]));
            System.out.println("-------------------");
        }
    }

    private static boolean isPrefixString(String s, String[] words) {
        int a = 0;
        while (a < words.length) {
            if (s.isEmpty()) {
                return true;
            } else {
                String b = words[a];
                if (s.length() < b.length() || !b.equals(s.substring(0, b.length()))) {
                    break;
                } else {
                    s = s.substring(b.length(), s.length());
                    a++;
                    if (s.isEmpty()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
