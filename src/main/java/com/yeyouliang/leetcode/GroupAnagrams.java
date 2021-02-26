package com.yeyouliang.leetcode;

import java.util.*;

/**
 * Created by YYL on 2021/2/26 : 23:27.
 */
public class GroupAnagrams {
    /**
     * 输入: ["eat", "tea", "tan", "ate", "add", "add", "add", "nat", "bat", "egg", "ta", "ta", "te", "te", "go", "go", "go", "gb", "gb", "gb", "lg", "lg"]
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["go","go","go"],
     * ["add","add","add"],
     * ["gb","gb","gb"],
     * ["nat","tan"],
     * ["ta","ta"],
     * ["lg","lg"],
     * ["te","te"],
     * ["bat"]
     * ["egg"]
     * ]
     */
    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "add", "add", "add", "nat", "bat", "egg", "ta", "ta", "te", "te", "go", "go", "go", "gb", "gb", "gb", "lg", "lg"};
        Map<Integer, List<String>> map = new HashMap<>();
        for (String string : strings) {
            int length = string.length();
            if (map.containsKey(length)) {
                List<String> list = map.get(length);
                list.add(string);
            } else {
                List<String> list = new ArrayList<>();
                list.add(string);
                map.put(length, list);
            }
        }
        for (List<String> list : map.values()) {
            print(list);
        }
    }

    public static void print(List<String> list) {
        if (list.size() < 2) {
            if (list.size() == 1) {
                System.out.println(Arrays.toString(list.toArray()));
            }
            return;
        }
        List<String> pass = new ArrayList<>();
        String first = list.get(0);
        int length = first.length();
        for (int i = 0; i < length; i++) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                if (!next.contains(first.substring(i, i + 1))) {
                    pass.add(next);
                    iterator.remove();
                }
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
        print(pass);
    }
}
