package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/8/27 : 21:54.
 */
public class PalindromeNumber {
    /**
     * 9. 回文数
     */
    public static void main(String[] args) {
        int[] ints = {1, 2, 10, 11, 12, 121, 123, 1024, 1991, 12321, 12345, 123321, 123456};
        for (int anInt : ints) {
            System.out.println(anInt + ":" + isPalindrome(anInt));
        }
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else {
            int[] num = new int[pn(x)[0] + 1];
            do {
                int[] b = pn(x);
                int yu = x / b[1];
                num[b[0]] = yu;
                x = x - b[1] * yu;
            } while (x >= 10);
            num[0] = x;
            int start = 0;
            int end = num.length - 1;
            boolean falg = true;
            while (end > start) {
                if (num[start] != num[end]) {
                    falg = false;
                    break;
                }
                start++;
                end--;
            }
            return falg;
        }
    }

    private static int[] pn(int n) {
        if (n >= 10_0000_0000) {//10亿
            return new int[]{9, 10_0000_0000};
        } else if (n >= 1_0000_0000) {//1亿
            return new int[]{8, 1_0000_0000};
        } else if (n >= 1000_0000) {//1千万
            return new int[]{7, 1000_0000};
        } else if (n >= 100_0000) {//1百万
            return new int[]{6, 100_0000};
        } else if (n >= 10_0000) {//1十万
            return new int[]{5, 10_0000};
        } else if (n >= 1_0000) {//1万
            return new int[]{4, 1_0000};
        } else if (n >= 1000) {//1千
            return new int[]{3, 1000};
        } else if (n >= 100) {//1百
            return new int[]{2, 100};
        } else {//1十
            return new int[]{1, 10};
        }
    }
}
