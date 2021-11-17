package com.yeyouliang.jianzhi;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/25 : 10:19.
 */
public class Offer11 {
    /**
     * 剑指 Offer 11. 旋转数组的最小数字
     * */
    public static void main(String[] args) {
        int[][] ints = {
                {3, 4, 5, 1, 2},
                {4, 5, 1, 2, 3},
                {5, 1, 2, 3, 4},
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 1},
                {2, 2, 2, 0, 1},
                {2, 2, 0, 1, 2},
                {2, 0, 1, 2, 2},
                {0, 1, 2, 2, 2},
                {1, 2, 2, 2, 0},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + minArray(anInt));
        }
    }

    private static int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        } else {
            int min = Math.min(numbers[0], numbers[1]);
            for (int number : numbers) {
                min = Math.min(number, min);
            }
            return min;
        }
    }
}
