package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/11/2 : 17:46.
 */
public class CompressStringLcci {
    /**
     * 面试题 01.06. 字符串压缩
     * */
    public static void main(String[] args) {
        String[] strings = {
                "abbccd",
                "aabcccccaaa",
                "aabcccccaef",
                "aabcccccaab",
                "abbccc",
                "abbccd",
                "abbcvd",
                "a",
                "aa",
                "ab",
                "leetcode",
                "loveleetcode"
        };
        for (String string : strings) {
            System.out.println(string + ":" + compressString(string));
        }
    }

    private static String compressString(String S) {
        if (S.length() > 0) {
            int length = S.length();
            S = S + " ";
            int a = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < S.length(); i++) {
                char b = S.charAt(i);
                char c = S.charAt(i - 1);
                if (b != c) {
                    sb.append(c);
                    sb.append(i - a);
                    if (sb.length() >= length) {
                        return S.substring(0, S.length() - 1);
                    }
                    a = i;
                }
            }
            return sb.toString();
        } else {
            return S;
        }
    }
}
