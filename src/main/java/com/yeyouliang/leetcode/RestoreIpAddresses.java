package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/8/20 : 19:19.
 */
public class RestoreIpAddresses {
    /**
     * 93. 复原 IP 地址
     */
    public static void main(String[] args) {
        List<String> list = restoreIpAddresses("25525511135");
        list.forEach(System.out::println);
    }

    private static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 4) {
            return list;
        }
        for (int i = 1; i < 4; i++) {
            String one = s.substring(0, i);
            if (one.length() > 1) {
                if (one.startsWith("0") || Integer.parseInt(one) > 255) {
                    break;
                }
            }
            for (int j = i + 1; j < i + 4; j++) {
                if (j > s.length()) {
                    break;
                }
                String two = s.substring(i, j);
                if (two.length() > 1) {
                    if (two.startsWith("0") || Integer.parseInt(two) > 255) {
                        break;
                    }
                }
                for (int k = j + 1; k < i + 8; k++) {
                    if (k > s.length()) {
                        break;
                    }
                    String three = s.substring(j, k);
                    if (three.length() > 1) {
                        if (three.startsWith("0") || three.length() > 3 || Integer.parseInt(three) > 255) {
                            break;
                        }
                    }
                    String four = s.substring(k, s.length());
                    if (four.length() > 1) {
                        if (four.startsWith("0") || four.length() > 3 || Integer.parseInt(four) > 255) {
                            continue;
                        }
                    }
                    if (four.length() == 0) {
                        continue;
                    }
                    list.add(one + "." + two + "." + three + "." + four);
                }
            }
        }
        return list;
    }
}
