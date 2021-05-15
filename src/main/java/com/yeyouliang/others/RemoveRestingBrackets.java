package com.yeyouliang.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/5/15 : 8:40.
 */
public class RemoveRestingBrackets {
    /**
     * 消除嵌套的括号
     * 问题描述：给定一个如下格式的字符串
     * （1，（2，3），（4，（5，6），7）），括号内的元素可以是数字，也可以是另一个括号，实现一个算法以消除嵌套的括号
     * 例如，把上面的表达式变成（1，2，3，4，5，6，7），若表达式有误，则报错
     */
    public static void main(String[] args) {
        String s = "（1，（2，3），（4，（5，6），7））";
        StringBuilder sb = new StringBuilder();
        sb.append("（");
        List<String> stack = new ArrayList<>();
        for (String s1 : s.substring(1, s.length() - 1).split("")) {
            try {
                switch (s1) {
                    case "（":
                        stack.add("（");
                        break;
                    case "）":
                        stack.remove(stack.size() - 1);
                        break;
                    default:
                        sb.append(s1);
                        break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("error");
                return;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("error");
            return;
        }
        sb.append("）");
        System.out.println(sb);
    }
}
