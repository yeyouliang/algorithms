package com.yeyouliang.others;

/**
 * Created by YYL on 2021/5/17 : 19:50.
 */
public class PrintAllCombination {
    /**
     * 输出字符串的所有组合
     * 问题描述：假设字符串中的所有字符都不重复，如何输出字符串的所有组合？例如，输入字符串"abc"，则输出a、b、c、ab、ac、bc、abc，共7种组合。
     */
    public static void main(String[] args) {
        String s = "abc";
        String[] split = s.split("");
        pac(split, 0, "");
    }

    public static void pac(String[] split, int index, String out) {
        if (index == split.length) {
            if (!out.equals("")) {
                System.out.println(out);
            }
            return;
        }
        pac(split, index + 1, out);
        pac(split, index + 1, out + split[index]);
    }
}
