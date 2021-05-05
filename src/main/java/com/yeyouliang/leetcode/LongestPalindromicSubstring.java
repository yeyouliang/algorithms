package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/4/11 : 11:33.
 */
public class LongestPalindromicSubstring {
    /**
     * 最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba"也是一个有效答案。
     * 输入: "cbbd"
     * 输出: "bb"
     */
    public static void main(String[] args) {
        String str = "bbabbb";
        int length = str.length();
        String result = null;
        int[][] ints = new int[length][2];
        for (int i = 0; i < length; i++) {
            System.out.println(result);
            if (i == 0) {
                result = str.substring(i, i + 1);
                continue;
            }
            int diff = ints[i - 1][1] - ints[i - 1][0];
            //表示上一个元素不是某个长度大于2的回文串的末尾
            if (diff == 0) {
                //跟前前一个元素比较
                if (i - 2 >= 0 && result.length() < 3 && str.substring(i - 2, i - 1).equals(str.substring(i, i + 1))) {
                    result = str.substring(i - 2, i + 1);
                    ints[i][0] = i - 2;
                    ints[i][1] = i;
                    continue;
                }
                //跟前一个元素比较
                if (result.length() < 2 && str.substring(i - 1, i).equals(str.substring(i, i + 1))) {
                    result = str.substring(i - 1, i + 1);
                    ints[i][0] = i - 1;
                    ints[i][1] = i;
                }
            } else {
                int open = i - diff - 2;
                //跟整个回文串的前面一个元素比较
                if (open >= 0 && str.substring(open, open + 1).equals(str.substring(i, i + 1))) {
                    result = str.substring(open, i + 1);
                    ints[i][0] = open;
                    ints[i][1] = i;
                    continue;
                }
                //将当前元素加入到回文串的末尾，对头尾进行比较，逐渐向中间靠拢
                int start = ints[i - 1][0];
                int end = ints[i - 1][1] + 1;
                while (true) {
                    //表示新加入一个元素后仍是一个回文串
                    if (end - start < 1) {
                        result = str.substring(start, i + 1);
                        ints[i][0] = start;
                        ints[i][1] = i;
                        break;
                    }
                    //只要有不同的就跳出
                    if (!str.substring(start, start + 1).equals(str.substring(end, end + 1))) {
                        break;
                    }
                    start+=1;
                    end-=1;
                }
            }
        }
        System.out.println(result);
    }
}
