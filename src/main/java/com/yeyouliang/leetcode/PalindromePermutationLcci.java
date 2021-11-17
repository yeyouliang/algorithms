package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/11/1 : 22:39.
 */
public class PalindromePermutationLcci {
    /**
     * 面试题 01.04. 回文排列
     * */
    public static void main(String[] args) {
        String[] strings = {
                "tactcoa",
                "a",
                "aa",
                "ab",
                "abc",
                "aba",
                "leetcode",
                "loveleetcode"
        };
        for (String string : strings) {
            System.out.println(string + ":" + canPermutePalindrome(string));
        }
    }

    private static boolean canPermutePalindrome(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (list.contains(c)) {
                list.remove(Character.valueOf(c));
            } else {
                list.add(c);
            }
        }
        return list.size() < 2;
    }
}
