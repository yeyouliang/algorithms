package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2020/12/25 : 20:10.
 */
public class BestTimeToBuyAndSellStock {//买卖股票的最佳时机
    public static void main(String[] args) {
        int[] ints = {7, 6, 4, 3, 1};
        int length = ints.length;
        int cha = ints[1] - ints[0];
        int start = 0;
        int end = 1;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int c = ints[j] - ints[i];
                if (c > cha) {
                    cha = c;
                    start = i;
                    end = j;
                }
            }
        }
        if (cha > 0) {
            System.out.println(start + "," + end + "," + cha);
        } else {
            System.out.println("no");
        }
    }
}
