package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/10/19 : 21:20.
 */
public class FindCommonCharacters {
    /**
     * 1002. 查找共用字符
     * */
    public static void main(String[] args) {
        String[][] strings = {
                {"bella", "label", "roller"},
                {"cool", "lock", "cook"},
                {"abcd", "abcde"},
                {"x"},
                {"xy"},
                {"xyy"},
                {"xxx"},
                {"x", "y"},
                {"a", "aa"},
                {"ae", "aea"},
        };
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string) + ":" + commonChars(string));
        }
    }

    private static List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();
        for (int i = 97; i <= 122; i++) {
            String a = String.valueOf((char) i);
            while (true) {
                int b = words.length;
                for (String word : words) {
                    if (word.contains(a)) {
                        b--;
                    } else {
                        break;
                    }
                }
                if (b == 0) {
                    list.add(a);
                    for (int j = 0; j < words.length; j++) {
                        String c = words[j];
                        int index = c.indexOf(a);
                        words[j] = c.substring(0, index) + c.substring(index + 1, c.length());
                    }
                } else {
                    break;
                }
            }
        }
        return list;
    }
}
