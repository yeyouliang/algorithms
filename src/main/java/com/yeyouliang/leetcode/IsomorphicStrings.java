package com.yeyouliang.leetcode;

import java.util.*;

/**
 * Created by YYL on 2021/9/25 : 13:38.
 */
public class IsomorphicStrings {
    /**
     * 205. 同构字符串
     * */
    public static void main(String[] args) {
        String[][] strings = {
                {"egg", "add"},
                {"foo", "bar"},
                {"paper", "title"},
                {"badc", "baba"},
        };
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string) + ":" + isIsomorphic(string[0], string[1]));
        }
    }

    private static boolean isIsomorphic(String s, String t) {
        boolean falg = true;
        Map<Character, Character> m1 = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (m1.containsKey(a)) {
                if (b != m1.get(a)) {
                    falg = false;
                    break;
                }
            } else {
                if (!m1.isEmpty()) {
                    if (list.contains(b)) {
                        falg = false;
                        break;
                    }
                }
                list.add(b);
                m1.put(a, b);
            }
        }
        return falg;
    }
}
