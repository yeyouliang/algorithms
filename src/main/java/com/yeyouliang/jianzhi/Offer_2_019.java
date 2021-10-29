package com.yeyouliang.jianzhi;

/**
 * Created by YYL on 2021/10/29 : 15:03.
 */
public class Offer_2_019 {
    /**
     * 剑指 Offer II 019. 最多删除一个字符得到回文
     */
    public static void main(String[] args) {
        String[] strings = {
                "ebcbbececabbacecbbcbe",
                "xabccba",
                "xabcba",
                "xaa",
                "axa",
                "aax",
                "baca",
                "abca",
                "acba",
                "acab",
                "xacca",
                "axcca",
                "acxca",
                "accxa",
                "accax",
                "xabcba",
                "axbcba",
                "abxcba",
                "abcxba",
                "abcbxa",
                "abcbax",
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
        if (s.length() < 3) {
            return true;
        } else {
            if (s.equals(new StringBuilder(s).reverse().toString())) {
                return true;
            } else {
                int a = 0;
                int b = s.length() - 1;
                while (a < b) {
                    if (s.charAt(a) == s.charAt(b)) {
                        a++;
                        b--;
                    } else {
                        if (a + 1 == b) {
                            return true;
                        }
                        int c;
                        int d;
                        if (s.charAt(a) == s.charAt(b - 1)) {
                            c = a;
                            d = b - 1;
                        } else if (s.charAt(a + 1) == s.charAt(b)) {
                            c = a + 1;
                            d = b;
                        } else {
                            return false;
                        }
                        while (c < d) {
                            if (s.charAt(c) == s.charAt(d)) {
                                c++;
                                d--;
                            } else {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return true;
            }
        }
    }
}
