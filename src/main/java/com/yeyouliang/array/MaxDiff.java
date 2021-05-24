package com.yeyouliang.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/5/22 : 14:53.
 */
public class MaxDiff {
    /**
     * 求数对之差的最大值
     * 问题描述：数组中的一个数字减去它右边子数组中的一个数字可以得到一个差值，求所有可能的差值中的最大值，例如，数组｛1，4，17，3，2，9｝中，最大的差值为17-2=15
     */
    public static void main(String[] args) {
        int[] ints = {1, 4, 17, 3, 2, 9};
        two(ints);
    }

    public static void one(int[] ints) {
        int max = ints[ints.length - 2] - ints[ints.length - 1];
        List<Integer> list = new ArrayList<>();
        list.add(ints[ints.length - 1]);
        for (int i = ints.length - 2; i >= 0; i--) {
            for (Integer integer : list) {
                max = Math.max(ints[i] - integer, max);
            }
            list.add(ints[i]);
        }
        System.out.println(max);
    }

    public static void two(int[] ints) {
        int max = ints[ints.length - 2] - ints[ints.length - 1];
        for (int i = ints.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < ints.length; j++) {
                max = Math.max(ints[i] - ints[j], max);
            }
        }
        System.out.println(max);
    }
}
