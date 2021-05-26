package com.yeyouliang.array;

/**
 * Created by YYL on 2021/5/25 : 20:29.
 */
public class MinDistanceBetweenTwoNum {
    /**
     * 求数组中两个元素的最小距离
     * 问题描述：给定一个数组，数组中含有重复元素，给出两个数n1和n2，求这两个数字在数组中所出现位置的最小距离，
     * 例如，数组｛4，5，6，4，7，4，6，4，7，8，5，6，4，3，10，8｝中，4和8的最小距离为2。
     */
    public static void main(String[] args) {
        int a = 4;
        int b = 8;
        int[] ints = {4, 5, 6, 4, 7, 4, 6, 4, 7, 8, 5, 6, 4, 3, 10, 8};
        //第一个数最近一次出现的下标
        int aa = -1;
        //第二个数最近一次出现的下标
        int bb = -1;
        //最小距离
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == a) {
                if (bb != -1) {
                    distance = Math.min(distance, i - bb);
                }
                aa = i;
            } else if (ints[i] == b) {
                if (aa != -1) {
                    distance = Math.min(distance, i - aa);
                }
                bb = i;
            }
        }
        System.out.println(distance);
    }
}
