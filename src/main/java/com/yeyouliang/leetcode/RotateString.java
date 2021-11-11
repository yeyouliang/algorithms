package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/11 : 12:37.
 */
public class RotateString {
    /**
     * 796. 旋转字符串
     * */
    public static void main(String[] args) {
        String[][] strings = {
                {"abcde", "cdeab"},
                {"abcde", "abced"},
                {"z", "ZZ"},
        };
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string) + ":" + rotateString(string[0], string[1]));
        }
    }

    private static boolean rotateString(String s, String goal) {
        if (s.length() == goal.length()) {
            if (s.length() > 0) {
                int countDown = s.length();
                while (countDown > 0) {
                    if (s.equals(goal)) {
                        return true;
                    } else {
                        s = s.substring(1, s.length()) + s.substring(0, 1);
                    }
                    countDown--;
                }
            }
        }
        return false;
    }
}
