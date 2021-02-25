package com.yeyouliang.leetcode;

import java.util.Stack;

/**
 * Created by YYL on 2021/2/25 : 22:41.
 */
public class ValidParentheses {
    private static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        String s = "()()(()(()))";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            String str = s.substring(i, i + 1);
            if (str.equals("(") || str.equals("[") || str.equals("{")) {
                stack.push(str);
            } else {
                if (stack.empty()) {
                    System.out.println("error:" + i);
                    return;
                }
                String peek = stack.peek();
                switch (str) {
                    case ")":
                        if (!peek.equals("(")) {
                            System.out.println("error:" + i);
                            return;
                        }
                        break;
                    case "]":
                        if (!peek.equals("[")) {
                            System.out.println("error:" + i);
                            return;
                        }
                        break;
                    case "}":
                        if (!peek.equals("{")) {
                            System.out.println("error:" + i);
                            return;
                        }
                        break;
                }
                stack.pop();
            }
        }
    }
}
