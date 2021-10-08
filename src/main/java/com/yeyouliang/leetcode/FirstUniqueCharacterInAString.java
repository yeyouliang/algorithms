package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YYL on 2021/10/7 : 13:30.
 */
public class FirstUniqueCharacterInAString {
    /**
     * 387. 字符串中的第一个唯一字符
     */
    public static void main(String[] args) {
        String[] strings = {
                "a",
                "aa",
                "ab",
                "leetcode",
                "loveleetcode"
        };
        for (String string : strings) {
            System.out.println(string + ":" + firstUniqChar(string));
        }
    }

    private static int firstUniqChar(String s) {
        Map<Character, List<Integer>> map = new LinkedHashMap<>();
        if (s.length() > 0) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    List<Integer> list = map.get(c);
                    Integer integer = list.get(1);
                    list.remove(1);
                    list.add(integer + 1);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(1);
                    map.put(c, list);
                }
            }
        }
        int index = -1;
        if (!map.isEmpty()) {
            for (List<Integer> list : map.values()) {
                if (list.get(1) == 1) {
                    index = list.get(0);
                    break;
                }
            }
        }
        return index;
    }
}
