package com.yeyouliang.leetcode;

import java.util.Stack;

/**
 * Created by YYL on 2021/2/25 : 22:41.
 */
public class ValidParentheses {
    /**
     * 20. 有效的括号
     * */
    public static void main(String[] args) {
        String[] strings = {"}}"};
        for (String string : strings) {
            System.out.println(string + ":" + isValid(string));
        }
    }

    private static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            String str = s.substring(i, i + 1);
            if (str.equals("(") || str.equals("[") || str.equals("{")) {
                stack.push(str);
            } else {
                if (stack.empty()) {
                    return false;
                }
                String peek = stack.peek();
                switch (str) {
                    case ")":
                        if (!peek.equals("(")) {
                            return false;
                        }
                        break;
                    case "]":
                        if (!peek.equals("[")) {
                            return false;
                        }
                        break;
                    case "}":
                        if (!peek.equals("{")) {
                            return false;
                        }
                        break;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}
