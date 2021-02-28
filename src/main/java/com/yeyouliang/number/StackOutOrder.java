package com.yeyouliang.number;

/**
 * Created by YYL on 2021/2/28 : 12:44.
 */
public class StackOutOrder {
    /**
     * 已知某一个序列，把序列中的字母按出现顺序压入一个栈，在入栈的任意过程中，允许栈中的字母出栈，求所有可能的出栈顺序。
     * <p>
     * in:abc
     * out:abc,acb,bac,bca,cba
     */
    public static void main(String[] args) {
        String origin = "abc";
        print(origin, 0, "", "");
    }

    public static void print(String origin, int index, String out, String stack) {
        if (index == origin.length()) {
            if (out.length() == origin.length()) {
                System.out.println(out);
            }
            return;
        }
        String nStack = stack;
        nStack += origin.substring(index, index + 1);
        String nnStack = nStack;
        print(origin, index + 1, out, nnStack);
        String nnnStack = new StringBuilder(nStack).reverse().toString();
        for (int i = 1; i <= nnnStack.length(); i++) {
            String no = out + nnnStack.substring(0, i);
            String st = nnStack.substring(0, nnStack.length() - i);
            print(origin, index + 1, no, st);
        }
    }
}
