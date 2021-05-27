package com.yeyouliang.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by YYL on 2021/5/21 : 20:39.
 */
public class He {
    /**
     * 求数组中两两相加等于20的组合种数
     * 问题描述：给定一个数组｛1，7，17，2，6，3，14｝，这个数组中满足条件的有两对组合——17+3=20和6+14=20。
     */
    public static void main(String[] args) {
        int he = 20;
        int[] ints = {1, 7, 17, 2, 6, 3, 14};
        List<Integer> list = new ArrayList<>();
        for (int anInt : ints) {
            boolean flag = false;
            for (Integer i : list) {
                if (i == he - anInt) {
                    System.out.println(i + "+" + anInt);
                    flag = true;
                    list.remove(i);
                    break;
                }
            }
            if (!flag) {
                list.add(anInt);
            }
        }
    }
}
