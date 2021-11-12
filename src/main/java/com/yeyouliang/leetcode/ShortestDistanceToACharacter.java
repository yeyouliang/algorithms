package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/12 : 9:11.
 */
public class ShortestDistanceToACharacter {
    /**
     * 821. 字符的最短距离
     * */
    public static void main(String[] args) {
        String[][] strings = {
                {"loveleetcode", "e"},
                {"aaab", "b"},
                {"aaba", "b"},
                {"abaa", "b"},
                {"baaa", "b"},
        };
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string) + ":" + Arrays.toString(shortestToChar(string[0], string[1].charAt(0))));
        }
    }

    private static int[] shortestToChar(String s, char c) {
        int length = s.length();
        int[] ints = new int[length];
        if (length == 1) {
            ints[0] = 0;
        } else {
            Arrays.fill(ints, -1);
            int last = -1;
            for (int i = 0; i < length; i++) {
                char a = s.charAt(i);
                if (c == a) {
                    ints[i] = 0;
                    for (int j = i - 1; j >= 0 && j > last; j--) {
                        int b = i - j;
                        if (ints[j] == -1) {
                            ints[j] = b;
                        } else {
                            if (ints[j] > b) {
                                ints[j] = b;
                            } else {
                                break;
                            }
                        }
                    }
                    last = i;
                } else {
                    if (last != -1) {
                        ints[i] = i - last;
                    }
                }
            }
        }
        return ints;
    }
}
