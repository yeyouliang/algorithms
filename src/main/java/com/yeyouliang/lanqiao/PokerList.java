package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/7/15 : 20:43.
 */
public class PokerList {
    /**
     * 扑克序列
     * 题目描述
     * A A 2 2 3 3 4 4， 一共4对扑克牌。请你把它们排成一行。
     * 要求：两个A中间有1张牌，两个2之间有2张牌，两个3之间有3张牌，两个4之间有4张牌。
     * 请填写出所有符合要求的排列中，字典序最小的那个。
     * 例如：22AA3344 比 A2A23344 字典序小。当然，它们都不是满足要求的答案。
     * 请通过浏览器提交答案。“A”一定不要用小写字母a，也不要用“1”代替。字符间一定不要留空格。
     */
    public static void main(String[] args) {
        List<String> value = Stream.of("", "", "", "", "", "", "", "").collect(Collectors.toList());
        List<List<String>> lists = new ArrayList<>();
        lists.add(Stream.of("7", "2", "2", "A").collect(Collectors.toList()));
        lists.add(Stream.of("7", "5", "5", "4").collect(Collectors.toList()));
        lists.add(Stream.of("7", "4", "4", "3").collect(Collectors.toList()));
        lists.add(Stream.of("7", "3", "3", "2").collect(Collectors.toList()));
        pl(value, lists, 0);
    }

    private static void pl(List<String> value, List<List<String>> lists, int index) {
        if (lists.size() == index) {
            System.out.println(value);
            return;
        }
        List<String> list = lists.get(index);
        int end = Integer.parseInt(list.get(0));
        int start = Integer.parseInt(list.get(1));
        int distance = Integer.parseInt(list.get(2));
        String p = list.get(3);
        for (int i = end; i >= start; i--) {
            String e = value.get(i);
            String s = value.get(i - distance);
            if (!e.isEmpty() || !s.isEmpty()) {
                continue;
            }
            List<String> v = new ArrayList<>(value);
            v.remove(i);
            v.add(i, p);
            v.remove(i - distance);
            v.add(i - distance, p);
            pl(v, lists, index + 1);
        }
    }
}
