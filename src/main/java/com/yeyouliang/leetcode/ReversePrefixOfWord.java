package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/22 : 14:15.
 */
public class ReversePrefixOfWord {
    /**
     * 2000. 反转单词前缀
     * */
    public static void main(String[] args) {
        String[][] strings = {
                {"abdefd", "d"},
                {"abcdefd", "d"},
                {"xyxzxe", "z"},
                {"abcd", "z"},
                {"d", "z"},
                {"z", "z"},
                {"zd", "z"},
                {"dz", "z"},
        };
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string) + ":" + reversePrefix(string[0], string[1].charAt(0)));
        }
    }

    private static String reversePrefix(String word, char ch) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                String a = word.substring(0, i + 1);
                String b = word.substring(i + 1, word.length());
                if (a.length() > 1) {
                    char[] chars = a.toCharArray();
                    int c = 0;
                    int d = i;
                    while (c < d) {
                        char e = chars[c];
                        chars[c] = chars[d];
                        chars[d] = e;
                        c++;
                        d--;
                    }
                    a = String.valueOf(chars);
                }
                word = a + b;
                break;
            }
        }
        return word;
    }
}
