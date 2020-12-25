package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2020/12/25 : 20:06.
 */
public class LongestCommonSubString {//最长公共字符串

    public static void main(String[] args) {
        String[] strings = {"6789", "56789", "34567"};
        int minIndex = 0;
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() < strings[0].length()) {
                minIndex = i;
            }
        }
        int minLength = strings[minIndex].length();
        String minString = strings[minIndex];
        String commonString = "";
        breakPoint:
        for (int i = minLength; i > 0; i--) {//4-1
            for (int j = 0; j < minLength; j++) {//0-3
                if (j + i <= minLength) {
                    boolean equql = true;
                    String cm = minString.substring(j, i + j);
                    for (String string : strings) {
                        if (!string.contains(cm)) {
                            equql = false;
                        }
                    }
                    if (equql) {
                        commonString = cm;
                        break breakPoint;
                    }
                }
            }
        }
        if ("".equals(commonString)) {
            System.out.println("no common String");
        } else {
            System.out.println("commonString:" + commonString);
        }
    }
}
