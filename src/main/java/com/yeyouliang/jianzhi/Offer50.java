package com.yeyouliang.jianzhi;

import java.util.*;

/**
 * Created by YYL on 2021/10/23 : 15:32.
 */
public class Offer50 {
    /**
     * 剑指 Offer 50. 第一个只出现一次的字符
     * */
    public static void main(String[] args) {
        String[] strings = {
                "abaccdeff",
                "abbaccdeff",
                "abbacdcdeff",
                "",
                "a",
                "aa",
                "aab",
                "ab",
        };
        for (String string : strings) {
            System.out.println(string + ":" + firstUniqChar(string));
        }
    }

    private static char firstUniqChar(String s) {
        List<Character> a = new ArrayList<>();
        Set<Integer> b = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (a.contains(c)) {
                int d = a.indexOf(c);
                b.add(d);
            } else {
                a.add(c);
            }
        }
        char e = ' ';
        for (int i = 0; i < a.size(); i++) {
            if (!b.contains(i)) {
                e = a.get(i);
                break;
            }
        }
        return e;
    }
}
