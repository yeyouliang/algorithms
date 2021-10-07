package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/10/7 : 13:30.
 */
public class FirstUniqueCharacterInAString {
    /**
     * 387. 字符串中的第一个唯一字符
     */
    public static void main(String[] args) {
        String[] strings = {
                "a",
                "aa",
                "ab",
                "leetcode",
                "loveleetcode"
        };
        for (String string : strings) {
            System.out.println(string + ":" + firstUniqChar(string));
        }
    }

    private static int firstUniqChar(String s) {
        int index = -1;
        if (s.length() > 0) {
            for (int i = 0; i < s.split("").length; i++) {
                String a = String.valueOf(s.charAt(i));
                int first = s.indexOf(a);
                int last = s.lastIndexOf(a);
                if (first == last) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
}
