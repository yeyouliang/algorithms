package com.yeyouliang.ti;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/22 : 22:20.
 */
public class T28 {
    public static void main(String[] args) {
        String[][] strings = {
                {"ababc", "abab"},
                {"ababc", "ab"},
                {"", ""},
                {"a", "a"},
                {"aa", "a"},
                {"aa", "aa"},
                {"ae", "aea"},
        };
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string) + ":" + m1(string[0], string[1]));
        }
    }

    /**
     * 计算字符串中子串出现的次数。
     */
    private static int m1(String a, String b) {
        int count = 0;
        if (a.length() >= b.length()) {
            if ("".equals(b)) {
                if ("".equals(a)) {
                    count++;
                }
            } else {
                for (int i = 0; i < a.length(); i++) {
                    if (a.length() - i < b.length()) {
                        break;
                    }
                    if (a.charAt(i) == b.charAt(0)) {
                        boolean falg = true;
                        for (int j = 1; j < b.length(); j++) {
                            if (a.charAt(i + j) != b.charAt(j)) {
                                falg = false;
                                break;
                            }
                        }
                        if (falg) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
