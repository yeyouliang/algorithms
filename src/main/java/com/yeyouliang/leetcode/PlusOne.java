package com.yeyouliang.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by YYL on 2021/3/1 : 20:23.
 */
public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{8, 8, 9, 9})));
    }

    /**
     * 输入：digits = [4,3,2,1]
     * 输出：[4,3,2,2]
     * 解释：输入数组表示数字 4321。
     */
    public static int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int length = digits.length;
        int add = 1;
        for (int i = length - 1; i >= 0; i--) {
            int a = digits[i] + add;
            if (a > 9) {
                stack.push(0);
                add = 1;
            } else {
                stack.push(a);
                add = 0;
            }
        }
        if (add == 1) {
            stack.push(1);
        }
        int[] ret = new int[stack.size()];
        int index = 0;
        while (!stack.empty()) {
            ret[index] = stack.pop();
            index++;
        }
        return ret;
    }
}
