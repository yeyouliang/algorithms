package com.yeyouliang.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2020/12/21 : 21:55.
 */
public class LongestCommonPrefix {//最长公共前缀
    /**
     * 14. 最长公共前缀
     * */
    public static void main(String[] args) {
        String[][] strings = {
                {"flower", "flow", "flight"},
                {"flower", "flow", "floght"},
                {"flower", "flowe", "flowt"},
                {"flower", "flower", "flowe"},
                {"flower", "flower", "flower"},
                {"floweri", "flowerit", "flowerip"},
                {"flow", "flow"},
                {"fllow", "filow"},
                {"d", "d"},
                {"a", "b"},
                {"d", "da", "d"},
                {"d", "da", "db"},
                {"d", "dcv", "dcx"},
                {"a", "b", "c"},
                {"a1", "b2", "c3"},
                {"def", "abcdef", "bcde"},
                {"dog", "racecar", "car"}
        };
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string) + ":" + longestCommonPrefix(string));
        }
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int min = 201;
        for (String str : strs) {
            min = Math.min(str.length(), min);
        }
        if (min == 0) {
            return "";
        }
        Stack<List<Integer>> stack = new Stack<>();
        stack.add(Stream.of(0, min - 1).collect(Collectors.toList()));
        int index = min;
        while (!stack.empty()) {
            List<Integer> pop = stack.pop();
            int start = pop.get(0);
            int end = pop.get(1);
            int half = (end - start) / 2;
            char c = strs[0].charAt(start + half);
            boolean falg = true;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(start + half) != c) {
                    falg = false;
                    break;
                }
            }
            if (falg) {
                if (end - start > 1) {
                    stack.add(Stream.of(start + half, end).collect(Collectors.toList()));
                    stack.add(Stream.of(start, start + half).collect(Collectors.toList()));
                }
            } else {
                index = start + half;
                stack.clear();
                if (half > 0) {
                    stack.add(Stream.of(start, start + half).collect(Collectors.toList()));
                }
            }
        }
        if (index == min) {
            char c = strs[0].charAt(index - 1);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(index - 1) != c) {
                    index--;
                    break;
                }
            }
        }
        return strs[0].substring(0, index);
    }
}
