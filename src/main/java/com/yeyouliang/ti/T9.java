package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/20 : 17:19.
 */
public class T9 {
    /**
     * 用递归实现字符串倒转
     */
    public static void main(String[] args) {
        String[] strings = {
                "a",
                "aa",
                "ab",
                "abc",
                "abcd",
                "abcde",
                "leetcode",
                "loveleetcode"
        };
        for (String string : strings) {
            System.out.println(string + ":" + sr(string));
        }
    }

    private static String sr(String s) {
        if (s != null && s.length() > 1) {
            s = s.substring(s.length() - 1, s.length()) + sr(s.substring(1, s.length() - 1)) + s.substring(0, 1);
        }
        return s;
    }
}
