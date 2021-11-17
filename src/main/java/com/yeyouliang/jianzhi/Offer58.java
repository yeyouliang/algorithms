package com.yeyouliang.jianzhi;

/**
 * Created by YYL on 2021/10/27 : 11:46.
 */
public class Offer58 {
    /**
     * 剑指 Offer 58 - I. 翻转单词顺序
     * */
    public static void main(String[] args) {
        String[] strings = {
                "",
                " ",
                "  ",
                "  d",
                "  d ",
                "the",
                "the sky is blue",
                "  hello world!  ",
                "a good   example",
        };
        for (String string : strings) {
            System.out.println(string + ":" + reverseWords(string));
        }
    }

    private static String reverseWords(String s) {
        s = " " + s + " ";
        boolean falg = false;
        int a = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (falg) {
                    sb.append(s.substring(i + 1, a + 1));
                    sb.append(" ");
                    falg = false;
                    a = -1;
                }
            } else {
                if (!falg) {
                    falg = true;
                    a = i;
                }
            }
        }
        return sb.length() > 0 ? (sb.charAt(sb.length() - 1) == ' ' ? sb.substring(0, sb.length() - 1) : sb.toString()) : sb.toString();
    }
}
