package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/9/30 : 22:03.
 */
public class NumberOfSegmentsInAString {
    /**
     * 434. 字符串中的单词数
     * */
    public static void main(String[] args) {
        String[] strings = {
                "Hello, my name is John",
                "",
                "a",
                "a  ",
                " a ",
                "  a",
                "ab  ",
                " ab ",
                "  ab",
                "a b ",
                "a   b",
                " a b ",
                " a  b",
        };
        for (String string : strings) {
            System.out.println(string + ":" + countSegments(string));
        }
    }

    private static int countSegments(String s) {
        int count = 0;
        if (s.length() > 0) {
            s = " " + s + " ";
            boolean a = false;
            for (int i = 0; i < s.length(); i++) {
                if (!" ".equals(s.substring(i, i + 1))) {
                    a = true;
                } else {
                    if (a) {
                        count++;
                        a = false;
                    }
                }
            }
        }
        return count;
    }
}
