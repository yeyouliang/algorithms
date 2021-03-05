package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/3/6 : 0:21.
 */
public class WordBreak {
    /**
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     */
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s.equals("")) {
            return true;
        }
        System.out.println(s);
        List<String> start = new ArrayList<>();
        for (String w : wordDict) {
            if (s.startsWith(w)) {
                start.add(w);
            }
        }
        boolean result;
        for (String s1 : start) {
            result = wordBreak(s.substring(s1.length(), s.length()), wordDict);
            if (result) {
                return true;
            }
        }
        return false;
    }
}
