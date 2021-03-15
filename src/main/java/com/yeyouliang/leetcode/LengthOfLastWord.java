package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/3/14 : 15:43.
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hello world A0 "));
    }

    public static int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.substring(i, i + 1).equals(" ")) {
                if (len != 0) {
                    break;
                }
            } else {
                len++;
            }
        }
        return len;
    }
}
