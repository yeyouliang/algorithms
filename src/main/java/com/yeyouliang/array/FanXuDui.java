package com.yeyouliang.array;

/**
 * Created by YYL on 2021/6/6 : 21:10.
 */
public class FanXuDui {
    /**
     * 求解数组中反序对的个数
     * 问题描述：给定一个数组a，如果a[i]＞a[j]（i＜j），那么a[i]与a[j]被称为一个反序，例如，给定数组｛1，5，3，2，6｝，共有（5，3）、（5，2）和（3，2）三个反序对
     */
    public static void main(String[] args) {
        int[] ints = {1, 5, 3, 2, 6};
        int count = 0;
        for (int i = 1; i < ints.length; i++) {
            for (int j = 0; j < i; j++) {
                if (ints[j] > ints[i]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
