package com.yeyouliang.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by YYL on 2021/10/23 : 14:36.
 */
public class UniqueMorseCodeWords {
    /**
     * 804. 唯一摩尔斯密码词
     */
    public static void main(String[] args) {
        String[][] strings = {
                {"gin", "zen", "gig", "msg"}
        };
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string) + ":" + uniqueMorseRepresentations(string));
        }
    }

    private static int uniqueMorseRepresentations(String[] words) {
        String[] strings = {
                ".-",
                "-...",
                "-.-.",
                "-..",
                ".",
                "..-.",
                "--.",
                "....",
                "..",
                ".---",
                "-.-",
                ".-..",
                "--",
                "-.",
                "---",
                ".--.",
                "--.-",
                ".-.",
                "...",
                "-",
                "..-",
                "...-",
                ".--",
                "-..-",
                "-.--",
                "--.."
        };
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 97;
                sb.append(strings[index]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
