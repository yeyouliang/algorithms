package com.yeyouliang.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/8/28 : 14:05.
 */
public class RomanToInteger {
    /**
     * 13. 罗马数字转整数
     * */
    public static void main(String[] args) {
        String[] s = {"I", "III", "IV", "VI", "VII", "IX", "LVIII", "MCMXCIV", "XLIX", "CMXCIX"};
        for (String s1 : s) {
            System.out.println(s1 + ":" + romanToInt(s1));
        }
    }

    /**
     * I:1
     * V:5
     * X:10
     * L:50
     * C:100
     * D:500
     * M:1000
     */
    private static int romanToInt(String s) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("I", Stream.of("1", "0", "V", "X").collect(Collectors.toList()));
        map.put("V", Stream.of("5", "1").collect(Collectors.toList()));
        map.put("X", Stream.of("10", "0", "L", "C").collect(Collectors.toList()));
        map.put("L", Stream.of("50", "1").collect(Collectors.toList()));
        map.put("C", Stream.of("100", "0", "D", "M").collect(Collectors.toList()));
        map.put("D", Stream.of("500", "1").collect(Collectors.toList()));
        map.put("M", Stream.of("1000", "1").collect(Collectors.toList()));
        int n = 0;
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            String a = s.substring(start, start + 1);
            List<String> list = map.get(a);
            int b = Integer.parseInt(list.get(0));
            if (start == end) {
                start++;
            } else {
                String c = s.substring(start + 1, start + 2);
                int d = 0;
                for (String s1 : list.subList(2, list.size())) {
                    if (c.equals(s1)) {
                        d = Integer.parseInt(map.get(s1).get(0));
                        break;
                    }
                }
                if (d != 0) {
                    if ("0".equals(list.get(1))) {
                        b = b * -1;
                    }
                    b+=d;
                    start += 2;
                } else {
                    start++;
                }
            }
            n += b;
        }
        return n;
    }
}
