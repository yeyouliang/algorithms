package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/3/14 : 15:43.
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hello world A0 "));
    }

    public static int lengthOfLastWord(String s) {
        boolean falg = false;
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (falg) {
                if (s.charAt(i) == 32) {
                    break;
                }else {
                    length++;
                }
            } else {
                if (s.charAt(i) != 32) {
                    falg = true;
                    length++;
                }
            }
        }
        return length;
    }
}
