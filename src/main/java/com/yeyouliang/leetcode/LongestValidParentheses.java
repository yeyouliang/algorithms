package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/2/20 : 21:50.
 */
public class LongestValidParentheses {//LeetCode 31：最长有效括号
    /**
     * (()->()->2
     * )()())->()()->4
     */
    public static void main(String[] args) {
        String s = ")((())()())()((((()()((()))(()))(())()(()(()()()((()))))()())())(";
        int length = s.length();
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        int start = -1;
        for (int i = 0; i < length; i++) {
            if (s.substring(i, i + 1).equals(")")) {
                if (start != -1) {
                    strings.add(s.substring(start, i + 1));
                    if (s.substring(i - 1, i).equals("(")) {
                        integers.add(i - 1);
                    }
                    start = i + 1;
                }
            }
            if (s.substring(i, i + 1).equals("(")) {
                start = i;
            }
        }
        System.out.println(strings.size());
        if (integers.size() > 0) {
            List<Integer> ii = new ArrayList<>();
            ii.add(1);
            int count = 1;
            for (int i = 1; i < integers.size(); i++) {
                if (integers.get(i) - integers.get(i - 1) > 2) {
                    ii.add(count);
                    count = 1;
                } else {
                    count++;
                    ii.add(count);
                }
            }
            System.out.println(ii.stream().max(Integer::compareTo).get());
        } else {
            System.out.println("0");
        }
    }
}
