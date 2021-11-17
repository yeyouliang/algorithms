package com.yeyouliang.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by YYL on 2021/10/27 : 14:51.
 */
public class Offer61 {
    /**
     * 剑指 Offer 61. 扑克牌中的顺子
     * */
    public static void main(String[] args) {
        int[][] ints = {
                {1,2,3,4,5},
                {1,2,3,4,6},
                {0,0,1,2,5},
                {0,1,2,5,6},
                {0,0,0,2,5},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + isStraight(anInt));
        }
    }

    private static boolean isStraight(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                if (list.contains(num)) {
                    return false;
                } else {
                    list.add(num);
                }
            }
        }
        if (list.size() >1) {
            int a = 5 - list.size();
            int b = 0;
            Collections.sort(list);
            for (int i = 0; i < list.size() - 1; i++) {
                b += (list.get(i + 1) - list.get(i) - 1);
            }
            if (a >= b) {
                return true;
            }
        }
        return false;
    }
}
