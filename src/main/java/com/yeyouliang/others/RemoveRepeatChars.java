package com.yeyouliang.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/5/16 : 13:44.
 */
public class RemoveRepeatChars {
    /**
     * 如何删除字符串中重复的字符
     * 问题描述：删除字符串中重复的字符，例如，"good"去掉重复的字符后就变为"god"
     */
    public static void main(String[] args) {
        String s = "good";
        List<String> list = new ArrayList<>();
        for (String s1 : s.split("")) {
            if (!list.contains(s1)) {
                list.add(s1);
            }
        }
        for (String s1 : list) {
            System.out.print(s1);
        }
    }
}
