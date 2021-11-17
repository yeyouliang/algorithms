package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/22 : 14:49.
 */
public class FinalValueOfVariableAfterPerformingOperations {
    /**
     * 2011. 执行操作后的变量值
     * */
    public static void main(String[] args) {
        String[][] strings = {
                {"--X"},
                {"X--"},
                {"++X"},
                {"X++"},
                {"--X", "X++", "X++"},
                {"++X", "++X", "X++"},
                {"X++", "++X", "--X", "X--"},
        };
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string) + ":" + finalValueAfterOperations(string));
        }
    }

    private static int finalValueAfterOperations(String[] operations) {
        int a = 0;
        int b = 0;
        for (String operation : operations) {
            if (operation.contains("+")) {
                a++;
            } else {
                b++;
            }
        }
        return a - b;
    }
}
