package com.yeyouliang.jianzhi;

/**
 * Created by YYL on 2021/10/29 : 15:03.
 */
public class Offer_2_019 {
    /**
     * 剑指 Offer II 019. 最多删除一个字符得到回文
     * */
    public static void main(String[] args) {
        String[] strings = {
                "aba",
                "abca",
                "abc",
                "leetcode",
                "loveleetcode"
        };
        for (String string : strings) {
            System.out.println(string + ":" + validPalindrome(string));
        }
    }

    private static boolean validPalindrome(String s) {
        boolean falg = false;
        if (s.length() < 3) {
            falg = true;
        } else {
            if (s.equals(new StringBuilder(s).reverse().toString())) {
                falg = true;
            } else {
                for (int i = 0; i < s.length(); i++) {
                    String a = s.substring(0, i) + s.substring(i + 1, s.length());
                    if (a.equals(new StringBuilder(a).reverse().toString())) {
                        falg = true;
                        break;
                    }
                }
            }
        }
        return falg;
    }
}
