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
                "abc",
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
                        boolean e = true;
                        if (s.charAt(a) == s.charAt(b - 1)) {
                            int c = a;
                            int d = b - 1;
                            while (c < d) {
                                if (s.charAt(c) == s.charAt(d)) {
                                    c++;
                                    d--;
                                } else {
                                    e = false;
                                    break;
                                }
                            }
                        }else {
                            e=false;
                        }
                        boolean f = true;
                        if (s.charAt(a + 1) == s.charAt(b)) {
                            int c = a + 1;
                            int d = b;
                            while (c < d) {
                                if (s.charAt(c) == s.charAt(d)) {
                                    c++;
                                    d--;
                                } else {
                                    f = false;
                                    break;
                                }
                            }
                        }else {
                            f=false;
                        }
                        return e || f;
                    }
                }
                return true;
            }
        }
    }
}
