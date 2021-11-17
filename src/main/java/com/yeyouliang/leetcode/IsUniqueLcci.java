package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/11/1 : 17:47.
 */
public class IsUniqueLcci {
    /**
     * 面试题 01.01. 判定字符是否唯一
     * */
    public static void main(String[] args) {
        String[] strings = {
                "a",
                "aa",
                "ab",
                "abc",
                "leetcode",
                "loveleetcode"
        };
        for (String string : strings) {
            System.out.println(string + ":" + isUnique(string));
        }
    }

    private static boolean isUnique(String astr) {
        if (astr.length() > 1) {
            for (int i = 1; i < astr.length(); i++) {
                char a = astr.charAt(i);
                for (int j = i - 1; j >= 0; j--) {
                    char b = astr.charAt(j);
                    if (a == b) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
