package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/9/28 : 20:57.
 */
public class ArrangingCoins {
    /**
     * 441. 排列硬币
     * */
    public static void main(String[] args) {
        System.out.println(arrangeCoins(0));
    }

    private static int arrangeCoins(int n) {
        int num = 0;
        if (n > 0) {
            num = 1;
            while (n - num >= 0) {
                n -= num;
                num++;
            }
            num--;
        }
        return num;
    }
}
