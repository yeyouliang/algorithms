package com.yeyouliang.leetcode;

import java.util.*;

/**
 * Created by YYL on 2021/10/21 : 11:20.
 */
public class NumberOfStringsThatAppearAsSubstringsInWord {
    /**
     * 1967. 作为子字符串出现在单词中的字符串数目
     */
    public static void main(String[] args) {
        String[][][] strings = {
                {{"abc", "bc", "d", "ab"}, {"abdab"}},
                {{"a", "b", "c", "abc", "bc", "d"}, {"abc"}},
                {{"abc", "bc", "d"}, {"abdabc"}},
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
        List<String> a = new ArrayList<>();
        Map<String, List<Integer>> b = new HashMap<>();
        for (String pattern : patterns) {
            if (a.contains(pattern)) {
                count++;
            } else {
                String c = pattern.substring(0, 1);
                List<Integer> d = new ArrayList<>();
                if (b.containsKey(c)) {
                    d = b.get(c);
                } else {
                    for (int i = 0; i < word.length(); i++) {
                        if (c.equals(word.substring(i, i + 1))) {
                            d.add(i);
                        }
                    }
                    if (!d.isEmpty()) {
                        b.put(c, d);
                    }
                }
                int e = 0;
                for (Integer integer : d) {
                    if (pattern.length() <= word.length() - integer) {
                        boolean f = true;
                        for (int i = 0; i < pattern.length() && i < word.length() - integer; i++) {
                            if (pattern.charAt(i) != word.charAt(i + integer)) {
                                f = false;
                                break;
                            }
                        }
                        if (f) {
                            e = 1;
                            break;
                        }
                    }
                }
                if (e > 0) {
                    count += e;
                    a.add(pattern);
                }
            }
        }
        return count;
    }
}
