package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/7/6 : 19:49.
 */
public class CannotByNum {
    /**
     * 买不到的数目
     * 小明开了一家糖果店。他别出心裁：把水果糖包成4颗一包和7颗一包的两种。糖果不能拆包卖。
     * 小朋友来买糖的时候，他就用这两种包装来组合。当然有些糖果数目是无法组合出来的，比如要买 10 颗糖。
     * 你可以用计算机测试一下，在这种包装情况下，最大不能买到的数量是17。大于17的任何数字都可以用4和7组合出来。
     * 本题的要求就是在已知两个包装的数量时，求最大不能组合出的数字。
     * 输入：
     * 两个正整数，表示每种包装中糖的颗数(都不多于1000)
     * 要求输出：
     * 一个正整数，表示最大不能买到的糖数
     * 不需要考虑无解的情况
     * 例如：
     * 用户输入：
     * 4 7
     * 程序应该输出：
     * 17
     * 再例如：
     * 用户输入：
     * 3 5
     * 程序应该输出：
     * 7
     */
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int count = 0;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        List<Integer> cannot = new ArrayList<>();
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (count >= max) {
                System.out.println(cannot.get(cannot.size() - 1));
                break;
            } else if (i < min) {
                cannot.add(i);
                count = 0;
            } else if (i == min || i == max) {
                count++;
            } else if (i < max) {
                if (i % min == 0) {
                    count++;
                } else {
                    cannot.add(i);
                    count = 0;
                }
            } else {
                int d1 = i - min;
                int d2 = i - max;
                if (cannot.contains(d1) && cannot.contains(d2)) {
                    cannot.add(i);
                    count = 0;
                } else {
                    count++;
                }
            }
        }
    }
}
