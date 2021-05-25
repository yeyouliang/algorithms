package com.yeyouliang.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/5/22 : 10:01.
 */
public class AppearOnlyOne {
    /**
     * 找出数组中只出现一次的数字
     */
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 2, 4, 3, 5, 4, 1};
        List<Integer> list = new ArrayList<>();
        for (int anInt : ints) {
            if (list.contains(anInt)) {
                list.remove(Integer.valueOf(anInt));
            } else {
                list.add(anInt);
            }
        }
        System.out.println(list);
    }
}
