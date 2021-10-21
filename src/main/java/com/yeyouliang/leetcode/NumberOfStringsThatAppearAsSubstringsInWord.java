package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/21 : 11:20.
 */
public class NumberOfStringsThatAppearAsSubstringsInWord {
    /**
     * 1967. 作为子字符串出现在单词中的字符串数目
     * */
    public static void main(String[] args) {
        String[][][] strings = {
                {{"a", "abc", "bc", "d"}, {"abc"}},
                {{"a", "b", "c"}, {"aaaaabbbbb"}},
                {{"a", "a", "a"}, {"ab"}},
        };
        for (String[][] string : strings) {
            System.out.println(Arrays.toString(string[0]));
            System.out.println(Arrays.toString(string[1]));
            System.out.println(numOfStrings(string[0], string[1][0]));
        }
    }

    private static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }
        return count;
    }
}
