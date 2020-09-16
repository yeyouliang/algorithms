package com.yeyouliang.number;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by YYL on 2020/9/14.
 */
public class ContinuousOddSum {

    /*
    * 小明看到一本书上写着：任何数字的立方都可以表示为连续奇数的和。比如：2^3 = 8 = 3 + 5，3^3 = 27 = 7 + 9 + 11，4^3 = 64 = 1 + 3 + ... + 15虽然他没有想出怎么证明，但他想通过计算机进行验证。
    * 请你帮助小明写出 111 的立方之连续奇数和表示法的起始数字。如果有多个表示方案，选择起始数字小的方案。
    * */
    @Test
    public void testCOS() {
        cos(111);
    }

    public void cos(int num) {
        int pingfang = num * num * num;
        String s = String.valueOf(num);
        String end = s.substring(s.length() - 1);
        int sunCount;
        if (end.equals("0") || end.equals("2") || end.equals("4") || end.equals("6") || end.equals("8")) {
            sunCount = 2;
        } else {
            sunCount = 3;
        }
        Stack<Integer> all = new Stack<>();
        for (int i = sunCount; i < pingfang; i += 2) {
            int a = i / 2;
            if (pingfang % i == 0) {
                int b = pingfang / i;
                int c = b % 2 == 0 ? b - 1 : b - 2;
                Stack<Integer> stack = new Stack<>();
                stack.push(c);
                for (int j = 1; j < a; j++) {
                    c -= 2;
                    stack.push(c);
                }
                if (c < 1) {
                    break;
                } else if (!stack.empty()) {
                    //stack.forEach(integer -> System.out.print(integer+","));
                    //System.out.println();
                    all.push(stack.peek());
                }
            }
        }
        if (!all.empty()) {
            System.out.println(all.peek());
        }
    }
}
