package com.yeyouliang.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by YYL on 2021/10/9 : 20:25.
 */
public class DistributeCandies {
    /**
     * 575. 分糖果
     * */
    public static void main(String[] args) {
        int[][] ints = {
                {1, 1, 2, 2, 3, 3},
                {1, 1, 2, 3},
                {1, 1},
                {1, 2},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + distributeCandies(anInt));
        }
    }

    private static int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i : candyType) {
            set.add(i);
        }
        return set.size() > candyType.length / 2 ? candyType.length / 2 : set.size();
    }
}
