package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/8/29 : 11:07.
 */
public class ImplementStrstr {
    /**
     * 28. 实现 strStr()
     * */
    public static void main(String[] args) {
        System.out.println(strStr("hello", "lll"));
    }

    private static int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int c = -1;
        int a = haystack.length();
        int b = needle.length();
        if (a < b) {
            return c;
        }
        for (int i = 0; i <= a - b; i++) {
            boolean falg = true;
            for (int j = 0; j < b; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    falg = false;
                    break;
                }
            }
            if (falg) {
                c = i;
                break;
            }
        }
        return c;
    }
}
